/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.integrationpattern.gerenciadores;

import dijalmasilva.businesspattern.entidades.Cliente;
import dijalmasilva.businesspattern.factory.CreateFactory;
import dijalmasilva.businesspattern.factory.Factory;
import dijalmasilva.businesspattern.interfaces.DaoCliente;
import java.util.List;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class GerenciadorCliente {

    public boolean addCliente(Cliente c){
        Factory factory = CreateFactory.create();
        DaoCliente dc = factory.criaDaoCliente();
        return dc.salvar(c);
    }
    
    public boolean removeCliente(Cliente c){
        Factory factory = CreateFactory.create();
        DaoCliente dc = factory.criaDaoCliente();
        return dc.remover(c);
    }
    
    public Cliente find(int id){
        Factory factory = CreateFactory.create();
        DaoCliente dc = factory.criaDaoCliente();
        return dc.buscar(id);
    }
    
    public List<Cliente> all(){
        Factory factory = CreateFactory.create();
        DaoCliente dc = factory.criaDaoCliente();
        return dc.todos();
    }
    
    public Cliente findByCPF(String cpf){
        Factory factory = CreateFactory.create();
        DaoCliente dc = factory.criaDaoCliente();
        return dc.buscarPorCPF(cpf);
    }
}
