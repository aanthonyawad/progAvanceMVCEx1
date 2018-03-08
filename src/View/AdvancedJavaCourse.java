/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.View1;
import Model.Exchange;
import View.View2;

/**
 *
 * @author Aanthony
 */
public class AdvancedJavaCourse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        
        Exchange e1 = new Exchange();
        View1 v1 = new View1(e1);
        View2 v2 = new View2();
        v2.init(v1.exchange);
        
        
    }
    
}
