/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.businesspattern.entidades;

import dijalmasilva.businesspattern.interfaces.Observable;
import dijalmasilva.businesspattern.interfaces.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class GameListener implements Observable{

    private Game game;
    private List<Observer<Game>> observadores;

    public GameListener(Game game) {
        this.game = game;
        this.observadores = new ArrayList<>();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<Observer<Game>> getObservadores() {
        return observadores;
    }

    public void setObservadores(List<Observer<Game>> observadores) {
        this.observadores = observadores;
    }
    
    public void alteraObservers(List<Cliente> obs){
        obs.stream().forEach((c) -> {
            observadores.add(c);
        });
    }

    @Override
    public void addObserver(Observer newObserver) {
        observadores.add(newObserver);
    }

    @Override
    public void removeObserver(Observer observer) {
        observadores.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observadores.stream().forEach((observer) -> {
            observer.update(game);
        });
    }
    
    
}
