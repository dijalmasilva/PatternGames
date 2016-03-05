/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.businesspattern.factory;

import dijalmasilva.businesspattern.interfaces.DaoAluguel;
import dijalmasilva.businesspattern.interfaces.DaoCliente;
import dijalmasilva.businesspattern.jpa.DaoGameImpl;
import dijalmasilva.businesspattern.interfaces.DaoGame;
import dijalmasilva.businesspattern.jpa.DaoAluguelImpl;
import dijalmasilva.businesspattern.jpa.DaoClienteImpl;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class FactoryImpl implements Factory{

    
    @Override
    public DaoGame criaDaoGame() {
        return new DaoGameImpl();
    }

    @Override
    public DaoCliente criaDaoCliente() {
        return new DaoClienteImpl();
    }

    @Override
    public DaoAluguel criaDaoAluguel() {
        return new DaoAluguelImpl();
    }

}
