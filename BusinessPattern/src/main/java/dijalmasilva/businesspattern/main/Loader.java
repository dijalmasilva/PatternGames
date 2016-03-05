/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.businesspattern.main;

import dijalmasilva.businesspattern.entidades.Game;
import dijalmasilva.businesspattern.interfaces.DaoGame;
import dijalmasilva.businesspattern.jpa.DaoGameImpl;
import java.util.List;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class Loader {

    public static void main(String[] args) {

        DaoGame dg = new DaoGameImpl();
        List<Game> todos = dg.todos();
//        Game buscar = dg.buscar(1);
//        System.out.println(buscar.getNome());
        todos.stream().forEach((jogo) -> {
            System.out.println(jogo.getNome());
        });
    }
}
