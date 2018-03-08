/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.View1;
import Model.Currency;
import Model.Exchange;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Aanthony
 */
public class View2 implements Observer {
    
    JFrame mainFrame ;
    JPanel boxPanel;
    JPanel livrePanel;
    JPanel euroPanel;
    GridLayout gridLayout;
    JLabel livreLabel;
    JLabel euroLabel;
    JTextArea livreTextArea;
    JTextArea euroTextArea;
    
    
   
    public View2() {
        mainFrame = new JFrame();
        boxPanel = new JPanel();
        gridLayout = new GridLayout(6,0);
        boxPanel.setLayout(gridLayout);
        mainFrame.add(boxPanel);
        
        livreLabel = new JLabel("LL");
        euroLabel = new JLabel("Euro");
        
        livreTextArea = new JTextArea(2,10);
        euroTextArea  = new JTextArea(2,10);
        
        livrePanel = new JPanel();
        livrePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        euroPanel = new JPanel();
        euroPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        livrePanel.add(livreTextArea);
        livrePanel.add(livreLabel);
        euroPanel.add(euroTextArea);
        euroPanel.add(euroLabel);
        
        
        boxPanel.add(livrePanel);
        boxPanel.add(euroPanel);
        
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setSize(300, 300);
    }
    

    
    @Override
    public void update(Observable o, Object o1) {
        Exchange ex = (Exchange) o;
        for(int i =0 ;i< ex.currencies.size() ; i++){
            if(ex.currencies.get(i).symbol.equals(livreLabel.getText())){
                livreTextArea.setText(""+View1.amount*ex.currencies.get(i).rate);
                System.out.println("gayery bel view2 bel ll");
            }
            
            if(ex.currencies.get(i).symbol.equals(euroLabel.getText())){
                euroTextArea.setText(""+View1.amount*ex.currencies.get(i).rate);
                System.out.println("gayery bel view2 bel euro");
            }
            
        }
        
    }
    
    public void init(Observable o){
        o.addObserver(this);
    }

    
    
    
}
