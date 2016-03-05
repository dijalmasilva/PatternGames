/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.businesspattern.jpa;

import dijalmasilva.businesspattern.entidades.Cliente;
import dijalmasilva.businesspattern.interfaces.DaoCliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class DaoClienteImpl implements DaoCliente{

    private final EntityManagerFactory factory;
    private final EntityManager em;

    public DaoClienteImpl() {
        this.factory = Persistence.createEntityManagerFactory("PatternGames");
        this.em = factory.createEntityManager();
    }
    
    
    @Override
    public boolean salvar(Cliente c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
//        closeAll();
        return true;
    }

    @Override
    public boolean remover(Cliente c) {
        em.getTransaction().begin();
        em.remove(em.merge(c));
        em.getTransaction().commit();
//        closeAll();
        return true;
    }

    @Override
    public Cliente buscar(int id) {
        Cliente find = em.find(Cliente.class, id);
//        closeAll();
        return find;
    }

    @Override
    public List<Cliente> todos() {
        Query createQuery = em.createNativeQuery("select * from cliente", Cliente.class);
//        closeAll();
        return createQuery.getResultList();
    }

    private void closeAll(){
        em.close();
        factory.close();
    }
}
