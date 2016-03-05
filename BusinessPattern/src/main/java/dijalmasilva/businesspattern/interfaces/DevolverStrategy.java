/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.businesspattern.interfaces;

import dijalmasilva.businesspattern.entidades.Aluguel;
import java.math.BigDecimal;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public interface DevolverStrategy {

    BigDecimal calcularMulta(Aluguel aluguel);
    
}
