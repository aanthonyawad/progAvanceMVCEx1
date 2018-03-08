/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Currency;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Aanthony
 */
public class Exchange extends Observable{
    public  ArrayList<Currency> currencies;
    public ArrayList<Observer> observers;
    

    
    public Exchange(){
         currencies = new ArrayList<Currency>();
         observers = new ArrayList<Observer>();
    }
    
    public void addObserver(Observer c){
        this.observers.add(c);
        this.setChanged();
        this.notifyObservers();
    }
    
    public void deleteObserver(Observer c){
        if(this.observers.contains(c))
            this.currencies.remove(c);
    }
    

    public  void modifyCurrency(String s , Double d){
        boolean found = false;
        for(int i =0 ; i< currencies.size(); i++){
            Currency c = (Currency)currencies.get(i);
            if(c.symbol.equalsIgnoreCase(s)){
                c.rate = d;
                found = true;
            }
        }
        if(!found){
            currencies.add(new Currency(s,d));
        }
        
        this.setChanged();
        this.notifyObservers();
    }
    public void notifyObservers(){
        for(Observer ob : observers){
            ob.update(this,null);
        }
        
    }
    public void workTheObs(){
        this.setChanged();
        this.notifyObservers();
    }
}
