/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.businesspattern.main;

import dijalmasilva.businesspattern.entidades.Game;
import dijalmasilva.businesspattern.enums.JogoEstado;
import dijalmasilva.businesspattern.interfaces.DaoAluguel;
import dijalmasilva.businesspattern.interfaces.DaoCliente;
import dijalmasilva.businesspattern.interfaces.DaoGame;
import dijalmasilva.businesspattern.jpa.DaoAluguelImpl;
import dijalmasilva.businesspattern.jpa.DaoClienteImpl;
import dijalmasilva.businesspattern.jpa.DaoGameImpl;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class Loader {

    public static void main(String[] args) {

        DaoGame dg = new DaoGameImpl();
        DaoCliente dc = new DaoClienteImpl();
        DaoAluguel dao = new DaoAluguelImpl();
        Game buscar = new Game(502, "The Sims 4", "Simulador", JogoEstado.DISPONIVEL);
//        Game buscar = dg.buscar(502);
//        buscar.devolver();
        dg.atualizar(buscar, 502);
    }
}
