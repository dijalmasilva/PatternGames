/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.businesspattern.main;

import dijalmasilva.businesspattern.entidades.Aluguel;
import dijalmasilva.businesspattern.entidades.Cliente;
import dijalmasilva.businesspattern.entidades.Game;
import dijalmasilva.businesspattern.interfaces.DaoAluguel;
import dijalmasilva.businesspattern.interfaces.DaoCliente;
import dijalmasilva.businesspattern.interfaces.DaoGame;
import dijalmasilva.businesspattern.jpa.DaoAluguelImpl;
import dijalmasilva.businesspattern.jpa.DaoClienteImpl;
import dijalmasilva.businesspattern.jpa.DaoGameImpl;
import java.time.LocalDate;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class Loader {

    public static void main(String[] args) {

        DaoGame dg = new DaoGameImpl();
        DaoCliente dc = new DaoClienteImpl();
        DaoAluguel dao = new DaoAluguelImpl();
//        Cliente c = new Cliente("100.300.054-18", "dijalmacz@gmail.com", "Dijalma Silva");
//        dc.salvar(c);
//        Game g = new Game("PES 2016", "Esporte");
//        dg.salvar(g);
        Cliente cliente = dc.todos().get(0);
        Game game = dg.todos().get(0);
        Aluguel a = new Aluguel(cliente, game, LocalDate.now());
        dao.salvar(a);
        
//        List<Game> todos = dg.disponiveis();
//        System.out.println(buscar.getNome());
//        todos.stream().forEach((jogo) -> {
//            System.out.println(jogo.getNome());
//        });
    }
}
