/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.businesspattern.interfaces;

import dijalmasilva.businesspattern.enums.JogoEstado;
import dijalmasilva.businesspattern.exceptions.OperationException;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public interface JogoState {

    JogoEstado alugar() throws OperationException;
    
    JogoEstado devolver() throws OperationException;
}
