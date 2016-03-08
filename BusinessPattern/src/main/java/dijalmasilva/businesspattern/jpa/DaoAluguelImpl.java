/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.businesspattern.jpa;

import dijalmasilva.businesspattern.entidades.Aluguel;
import dijalmasilva.businesspattern.interfaces.DaoAluguel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class DaoAluguelImpl implements DaoAluguel {

    private final EntityManagerFactory factory;
    private final EntityManager em;

    public DaoAluguelImpl() {
        this.factory = Persistence.createEntityManagerFactory("PatternGames");
        this.em = factory.createEntityManager();
    }

    @Override
    public boolean salvar(Aluguel a) {
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean remover(Aluguel a) {
        em.getTransaction().begin();
        em.remove(em.merge(a));
        em.getTransaction().commit();
        return true;
    }

    @Override
    public Aluguel buscar(int id) {
        return em.find(Aluguel.class, id);
    }

    @Override
    public List<Aluguel> todos() {
        return em.createNativeQuery("select * from aluguel", Aluguel.class).getResultList();
    }

    @Override
    public Aluguel buscarPorGame(int id_game) {
        TypedQuery<Aluguel> query = em.createQuery("SELECT a FROM Aluguel a WHERE a.game.id = :id_game", Aluguel.class);
        query.setParameter("id_game", id_game);
        return query.getSingleResult();
    }

    @Override
    public Aluguel buscarPorGameAndCliente(int id_game, int id_cliente) {
        TypedQuery<Aluguel> query = em.createQuery("SELECT a FROM Aluguel a WHERE a.game.id = :id_game and a.cliente.id = :id_cliente",
                Aluguel.class);
        query.setParameter("id_game", id_game);
        query.setParameter("id_cliente", id_cliente);
        try {
            return query.getSingleResult();
        }catch (NoResultException ex){
            return null;
        }
    }
}
