/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.businesspattern.factory;

import dijalmasilva.businesspattern.interfaces.DaoAluguel;
import dijalmasilva.businesspattern.interfaces.DaoCliente;
import dijalmasilva.businesspattern.interfaces.DaoGame;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public interface Factory {

    DaoGame criaDaoGame();
    
    DaoCliente criaDaoCliente();
    
    DaoAluguel criaDaoAluguel();
}
