/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.businesspattern.entidades;

import dijalmasilva.businesspattern.enums.JogoEstado;
import dijalmasilva.businesspattern.exceptions.OperationException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Entity
public class Game implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String genero;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Observadores")
    private List<Cliente> observadores;
    @Enumerated(EnumType.STRING)
    private JogoEstado estado;

    public Game() {
    }

    public Game(String nome, String genero, List<Cliente> observadores) {
        this.nome = nome;
        this.genero = genero;
        this.observadores = observadores;
        this.estado = JogoEstado.DISPONIVEL;
    }

    public Game(String nome, String genero) {
        this.nome = nome;
        this.genero = genero;
        this.observadores = new ArrayList<>();
        this.estado = JogoEstado.DISPONIVEL;
    }

    public Game(int id, String nome, String genero, JogoEstado estado) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.estado = estado;
    }
    
    public Game(String nome, String genero, List<Cliente> observadores, JogoEstado estado) {
        this.nome = nome;
        this.genero = genero;
        this.observadores = observadores;
        this.estado = estado;
    }

    public Game(int id, String nome, String genero, List<Cliente> observadores, JogoEstado estado) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.observadores = observadores;
        this.estado = estado;
    }
    
    public void devolver() throws OperationException{
        this.estado =  estado.devolver();
        GameListener listener = new GameListener(this);
        listener.notifyObservers();
    }
    

    public void alugar() throws OperationException{
        this.estado = estado.alugar();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Cliente> getObservadores() {
        return observadores;
    }

    public void setObservadores(List<Cliente> observadores) {
        this.observadores = observadores;
    }
    
    public void addObservadores(Cliente c){
        this.observadores.add(c);
    }
    
    public void removeObservadores(Cliente c){
        this.observadores.remove(c);
    }

    public JogoEstado getEstado() {
        return estado;
    }

    public void setEstado(JogoEstado estado) {
        this.estado = estado;
    }
    
}
