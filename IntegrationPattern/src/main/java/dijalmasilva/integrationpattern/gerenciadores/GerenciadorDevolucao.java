/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.integrationpattern.gerenciadores;

import dijalmasilva.businesspattern.entidades.Aluguel;
import java.math.BigDecimal;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class GerenciadorDevolucao {

    public boolean verificaAtraso(Aluguel a) {
       return a.atrasado();
    }
    
    public BigDecimal calcularMulta(Aluguel a){
        return a.calcularMulta();
    }
    
    public boolean devolver(Aluguel a){
        return new GerenciadorGame().devolver(a.getGame());
    }
}
