/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.businesspattern.entidades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class CalculadoraDeDatas {
    
    public long contarDias(LocalDate dataDeDevolucao, LocalDate hj){
        
        long dias = ChronoUnit.DAYS.between(dataDeDevolucao, hj);
        
        System.out.println(dias);

        return dias;
    }
}
