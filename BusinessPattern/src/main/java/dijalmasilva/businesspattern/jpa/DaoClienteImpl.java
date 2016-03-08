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
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class DaoClienteImpl implements DaoCliente {

    private final EntityManagerFactory factory;
    private final EntityManager em;

    public DaoClienteImpl() {
        this.factory = Persistence.createEntityManagerFactory("PatternGames");
        this.em = factory.createEntityManager();
    }

    @Override
    public boolean salvar(Cliente c) {
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
//        closeAll();
            return true;
        } catch (ConstraintViolationException ex) {
            ex.printStackTrace();
            return false;
        }
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
        Query createQuery = em.createNativeQuery("select * from cliente order by nome", Cliente.class);
//        closeAll();
        return createQuery.getResultList();
    }

    private void closeAll() {
        em.close();
        factory.close();
    }

    @Override
    public Cliente buscarPorCPF(String cpf) {
        Query query = em.createQuery("SELECT c from Cliente c where c.cpf = :cpfCliente", Cliente.class);
        query.setParameter("cpfCliente", cpf);
        return (Cliente) query.getSingleResult();
    }
}
