/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijalmasilva.businesspattern.enums;

import dijalmasilva.businesspattern.exceptions.OperationException;
import dijalmasilva.businesspattern.interfaces.JogoState;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public enum JogoEstado implements JogoState {

    ALUGADO {
        @Override
        public JogoEstado alugar() {
            throw new OperationException("Jogo já foi alugado!");
        }

        @Override
        public JogoEstado devolver() {
            System.out.println("Jogo devolvido!");
            return DISPONIVEL;
        }
    }, 
    
    DISPONIVEL{
        @Override
        public JogoEstado alugar() {
            System.out.println("Jogo alugado!");
            return ALUGADO;
        }

        @Override
        public JogoEstado devolver() {
            throw new OperationException("O jogo já está disponível!");
        }
    };

}
