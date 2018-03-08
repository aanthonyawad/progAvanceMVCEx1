/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Aanthony
 */
public class Currency {
    public String symbol;
    public Double rate;
    
    public Currency(String symbol , Double rate){
        this.symbol = symbol ;
        this.rate = rate; 
    }

  
    
   

}
