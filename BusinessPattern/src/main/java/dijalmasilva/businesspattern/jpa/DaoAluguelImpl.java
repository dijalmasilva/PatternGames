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
import javax.persistence.Persistence;
import javax.persistence.Query;

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
//        closeAll();
        return true;
    }

    @Override
    public boolean remover(Aluguel a) {
        em.getTransaction().begin();
        em.remove(em.merge(a));
        em.getTransaction().commit();
//        closeAll();
        return true;
    }

    @Override
    public Aluguel buscar(int id) {
        Aluguel find = em.find(Aluguel.class, id);
//        closeAll();
        return find;
    }

    @Override
    public List<Aluguel> todos() {
        Query createQuery = em.createNativeQuery("select * from aluguel", Aluguel.class);
//        closeAll();
        return createQuery.getResultList();
    }

//    private void closeAll() {
//        em.close();
//        factory.close();
//    }
}
