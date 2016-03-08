/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.businesspattern.entidades;

import dijalmasilva.businesspattern.interfaces.DevolverStrategy;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class EspecialStrategy implements DevolverStrategy{

    private final BigDecimal multa = new BigDecimal("3.00");
    
    @Override
    public BigDecimal calcularMulta(Aluguel aluguel) {
        
        BigDecimal dias = new BigDecimal(new CalculadoraDeDatas().
                contarDias(aluguel.getDataDeDevolucao(), LocalDate.now()));
        
        BigDecimal result = dias.multiply(new BigDecimal(3));
        
        return multa.add(result);
    }
}
