/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.integrationpattern.main;

import dijalmasilva.businesspattern.entidades.Game;
import dijalmasilva.integrationpattern.gerenciadores.GerenciadorGame;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */ 
public class Loader {

    public static void main(String[] args) {
        GerenciadorGame g = new GerenciadorGame();
        Game game = new Game("FIFA 16", "Esporte");
        g.salvar(game);
    }
}
