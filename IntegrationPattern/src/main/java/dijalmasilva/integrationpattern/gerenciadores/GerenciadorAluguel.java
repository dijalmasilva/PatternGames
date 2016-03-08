/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.integrationpattern.gerenciadores;

import dijalmasilva.businesspattern.entidades.Aluguel;
import dijalmasilva.businesspattern.enums.TipoAluguel;
import dijalmasilva.businesspattern.factory.CreateFactory;
import dijalmasilva.businesspattern.factory.Factory;
import dijalmasilva.businesspattern.interfaces.DaoAluguel;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class GerenciadorAluguel {

    public boolean add(Aluguel a) {
        Factory factory = CreateFactory.create();
        DaoAluguel dao = factory.criaDaoAluguel();
        return dao.salvar(a);
    }

    public boolean remove(Aluguel a) {
        Factory factory = CreateFactory.create();
        DaoAluguel dao = factory.criaDaoAluguel();
        return dao.remover(a);
    }

    public Aluguel find(int id) {
        Factory factory = CreateFactory.create();
        DaoAluguel dao = factory.criaDaoAluguel();
        return dao.buscar(id);
    }

    public List<Aluguel> all() {
        Factory factory = CreateFactory.create();
        DaoAluguel dao = factory.criaDaoAluguel();
        return dao.todos();
    }

    public boolean alugar(Aluguel a) {
        return new GerenciadorGame().alugar(a.getGame());
    }

    public TipoAluguel tipoDeAluguel(Aluguel a) {
        return a.getTipoDeAluguel();
    }

    public String retornaDataFormatada(Aluguel a) {
        return a.getDataDeDevolucao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public Aluguel findByGameId(int id_game) {
        Factory factory = CreateFactory.create();
        DaoAluguel dao = factory.criaDaoAluguel();
        return dao.buscarPorGame(id_game);
    }

    public boolean devolver(Aluguel a) {
        GerenciadorGame gg = new GerenciadorGame();
        if (gg.devolver(a.getGame())) {
            return remove(a);
        }
        return false;
    }

    public boolean atrasado(Aluguel a) {
        return a.atrasado();
    }

    public BigDecimal calcularMulta(Aluguel a) {
        return a.calcularMulta();
    }

    public Aluguel findByGameAndClient(int id_game, int id_cliente) {
        Factory factory = CreateFactory.create();
        DaoAluguel dao = factory.criaDaoAluguel();
        return dao.buscarPorGameAndCliente(id_game, id_cliente);
    }
}
