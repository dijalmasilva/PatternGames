/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.businesspattern.interfaces;

import dijalmasilva.businesspattern.entidades.Aluguel;
import java.util.List;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public interface DaoAluguel {

    boolean salvar(Aluguel a);
    
    boolean remover(Aluguel a);
    
    Aluguel buscar(int id);
    
    Aluguel buscarPorGame(int id_game);
    
    Aluguel buscarPorGameAndCliente(int id_game, int id_cliente);
    
    List<Aluguel> todos();
}
