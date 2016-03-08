/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.integrationpattern.main;

import dijalmasilva.businesspattern.entidades.Aluguel;
import dijalmasilva.integrationpattern.gerenciadores.GerenciadorAluguel;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */ 
public class Loader {

    public static void main(String[] args) {
        GerenciadorAluguel a = new GerenciadorAluguel();
        Aluguel aluguel = a.find(1109);
        if (a.atrasado(aluguel)){
            System.out.println(aluguel.calcularMulta() + "R$");
        }
//        g.devolver(game);
    }
}
