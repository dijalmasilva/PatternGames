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
        return em.createNativeQuery("select * from game order by nome", Game.class).getResultList();
    }

    @Override
    public Game buscar(int id) {
        return em.find(Game.class, id);
    }

    @Override
    public boolean salvar(Game g) {
        em.getTransaction().begin();
        em.persist(g);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean remover(Game g) {
        em.getTransaction().begin();
        em.remove(em.merge(g));
        em.getTransaction().commit();
        return true;
    }

    @Override
    public List<Game> alugados() {
        return em.createNativeQuery("select * from game where estado = 'ALUGADO'", Game.class).getResultList();
    }

    @Override
    public List<Game> disponiveis() {
        return em.createNativeQuery("select * from game where estado = 'DISPONIVEL'", Game.class).getResultList();
    }

    @Override
    public boolean atualizar(Game g) {
        em.getTransaction().begin();
        em.merge(g);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean atualizar(Game g, int id) {
        Game find = buscar(id);
        find = g;
        em.getTransaction().begin();
        em.merge(find);
        em.getTransaction().commit();
        return true;
    }
}
