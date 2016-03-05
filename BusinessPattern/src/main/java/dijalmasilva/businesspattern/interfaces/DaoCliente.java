/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.businesspattern.interfaces;

import dijalmasilva.businesspattern.entidades.Cliente;
import java.util.List;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public interface DaoCliente {

    boolean salvar(Cliente c);
    
    boolean remover(Cliente c);
    
    Cliente buscar(int id);
    
    List<Cliente> todos();
}
