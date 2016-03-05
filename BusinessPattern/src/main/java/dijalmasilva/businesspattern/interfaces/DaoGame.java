/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.businesspattern.interfaces;

import dijalmasilva.businesspattern.entidades.Game;
import java.util.List;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public interface DaoGame {

    boolean salvar(Game g);
    
    boolean remover(Game g);
    
    List<Game> todos();
    
    Game buscar(int id);
}
