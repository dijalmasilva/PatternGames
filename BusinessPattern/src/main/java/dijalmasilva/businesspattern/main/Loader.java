/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.businesspattern.main;

import dijalmasilva.businesspattern.entidades.Cliente;
import dijalmasilva.businesspattern.entidades.Game;
import dijalmasilva.businesspattern.interfaces.DaoAluguel;
import dijalmasilva.businesspattern.interfaces.DaoCliente;
import dijalmasilva.businesspattern.interfaces.DaoGame;
import dijalmasilva.businesspattern.jpa.DaoAluguelImpl;
import dijalmasilva.businesspattern.jpa.DaoClienteImpl;
import dijalmasilva.businesspattern.jpa.DaoGameImpl;
import java.util.List;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class Loader {

    public static void main(String[] args) {

        DaoGame dg = new DaoGameImpl();
        DaoCliente dc = new DaoClienteImpl();
        DaoAluguel dao = new DaoAluguelImpl();
        
        Cliente cliente = dc.buscar(1105);
        List<Game> alugados = dg.alugados();
        cliente.update(alugados.get(0));
    }
}
