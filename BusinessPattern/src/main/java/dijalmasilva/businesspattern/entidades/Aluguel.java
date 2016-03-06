/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.businesspattern.entidades;

import dijalmasilva.businesspattern.enums.TipoAluguel;
import dijalmasilva.businesspattern.interfaces.DevolverStrategy;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Entity
@Access(AccessType.FIELD)
public class Aluguel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    private Cliente cliente;
    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    private Game game;
    @Temporal(value = TemporalType.DATE)
    private LocalDate dataDoAluguel;
    @Temporal(value = TemporalType.DATE)
    private LocalDate dataDeDevolucao;
    @Transient
    private TipoAluguel tipoDeAluguel;
    @Transient
    private DevolverStrategy strategy;

    public Aluguel() {
        this.dataDoAluguel = LocalDate.now();
        verificaTipoDeAluguel();
        verificaDataDeDevolucao();
    }

    public Aluguel(Cliente cliente, Game game, LocalDate dataDoAluguel) {
        this.cliente = cliente;
        this.game = game;
        this.dataDoAluguel = dataDoAluguel;
        verificaTipoDeAluguel();
        verificaDataDeDevolucao();
    }

    public boolean atrasado() {

        return LocalDate.now().isBefore(dataDeDevolucao);
    }

    public BigDecimal calcularMulta() {

        if (atrasado()) {

            switch (tipoDeAluguel) {
                case ESPECIAL:
                    strategy = new EspecialStrategy();
                    break;
                case COMUM:
                    strategy = new ComumStrategy();
                    break;
            }

            return strategy.calcularMulta(this);
        }
        
        return BigDecimal.ZERO;
    }

    private void verificaTipoDeAluguel() {
        if (dataDoAluguel.getDayOfWeek().equals(DayOfWeek.SATURDAY) || dataDoAluguel.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            this.tipoDeAluguel = TipoAluguel.ESPECIAL;
        } else {
            this.tipoDeAluguel = TipoAluguel.COMUM;
        }
    }

    private void verificaDataDeDevolucao() {
        if (tipoDeAluguel == TipoAluguel.ESPECIAL) {
            this.dataDeDevolucao = this.dataDoAluguel.plusDays(2L);
        } else {
            this.dataDeDevolucao = this.dataDoAluguel.plusDays(1L);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public LocalDate getDataDoAluguel() {
        return dataDoAluguel;
    }

    public void setDataDoAluguel(LocalDate dataDoAluguel) {
        this.dataDoAluguel = dataDoAluguel;
    }

    public LocalDate getDataDeDevolucao() {
        return dataDeDevolucao;
    }

    public void setDataDeDevolucao(LocalDate dataDeDevolucao) {
        this.dataDeDevolucao = dataDeDevolucao;
    }

    public TipoAluguel getTipoDeAluguel() {
        return tipoDeAluguel;
    }

    public void setTipoDeAluguel(TipoAluguel tipoDeAluguel) {
        this.tipoDeAluguel = tipoDeAluguel;
    }

    public DevolverStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(DevolverStrategy strategy) {
        this.strategy = strategy;
    }
    
    @Override
    public String toString() {
        return "Aluguel{" + "id=" + id + ", cliente=" + cliente + ", game=" + game + ", dataDoAluguel=" + dataDoAluguel + ", dataDeDevolucao=" + dataDeDevolucao + ", tipoDeAluguel=" + tipoDeAluguel + ", strategy=" + strategy + '}';
    }
    
    
}
