/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.integrationpattern.gerenciadores;

import dijalmasilva.businesspattern.entidades.Game;
import dijalmasilva.businesspattern.enums.JogoEstado;
import dijalmasilva.businesspattern.exceptions.OperationException;
import dijalmasilva.businesspattern.factory.CreateFactory;
import dijalmasilva.businesspattern.factory.Factory;
import java.util.List;
import dijalmasilva.businesspattern.interfaces.DaoGame;
import java.util.ArrayList;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class GerenciadorGame {

    public boolean salvar(Game game){
        Factory factory = CreateFactory.create();
        DaoGame dao = factory.criaDaoGame();
        return dao.salvar(game);
    }
    
    public boolean remover(Game game){
        Factory factory = CreateFactory.create();
        DaoGame dao = factory.criaDaoGame();
        return dao.remover(game);
    }
    
    public Game buscar(int id){
        Factory factory = CreateFactory.create();
        DaoGame dao = factory.criaDaoGame();
        return dao.buscar(id);
    }
    
    public List<Game> listarTodos(){
        Factory factory = CreateFactory.create();
        DaoGame dao = factory.criaDaoGame();
        return dao.todos();
    }

    public boolean update(Game game){
        Factory factory = CreateFactory.create();
        DaoGame dao = factory.criaDaoGame();
        Game g = dao.buscar(game.getId());
        g = game;
        return dao.salvar(g);
    }
    
    public boolean alugar(Game game){
        try{
            game.alugar();
            return true;
        }catch(OperationException ex){
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean devolver(Game game){
        try{
            game.devolver();
            return true;
        }catch(OperationException ex){
            System.out.println(ex);
            return false;
        }
    }
    
    public List<Game> toReturn(){
        List<Game> all = listarTodos();
        List<Game> devoGames = new ArrayList<>();
        
        all.stream().filter((g) -> (g.getEstado() == JogoEstado.ALUGADO)).forEach((g) -> {
            devoGames.add(g);
        });
        
        return devoGames;
    }
}
