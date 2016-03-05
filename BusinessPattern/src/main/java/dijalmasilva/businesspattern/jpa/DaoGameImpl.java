/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.businesspattern.jpa;

import dijalmasilva.businesspattern.entidades.Game;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import dijalmasilva.businesspattern.interfaces.DaoGame;
import javax.persistence.Query;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class DaoGameImpl implements DaoGame{

    private final EntityManagerFactory factory;
    private final EntityManager em;

    public DaoGameImpl() {
        this.factory = Persistence.createEntityManagerFactory("PatternGames");
        this.em = factory.createEntityManager();
    }

    
    @Override
    public List<Game> todos() {
        List resultList = em.createNativeQuery("select * from game", Game.class).getResultList();
//        closeAll();
        return resultList;
    }

    @Override
    public Game buscar(int id) {
        Game g = em.find(Game.class, id);
//        closeAll();
        return g;
    }

    @Override
    public boolean salvar(Game g) {
        em.getTransaction().begin();
        em.persist(g);
        em.getTransaction().commit();
//        closeAll();
        return true;
    }

    @Override
    public boolean remover(Game g) {
        em.getTransaction().begin();
        em.remove(em.merge(g));
        em.getTransaction().commit();
//        closeAll();
        return true;
    }

    private void closeAll(){
        em.close();
        factory.close();
    }
}
