/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijalmasilva.businesspattern.factory;

/**
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class CreateFactory {

    public static Factory create(){
        return new FactoryImpl();
    }
}
