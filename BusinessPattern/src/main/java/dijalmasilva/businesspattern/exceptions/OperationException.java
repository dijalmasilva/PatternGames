/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.businesspattern.exceptions;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class OperationException extends RuntimeException{

    public OperationException(String message) {
        super(message);
    }

    public OperationException() {
        
    }
    
}
