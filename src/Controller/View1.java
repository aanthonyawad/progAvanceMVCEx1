/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Exchange;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Aanthony
 */
public class View1 {
    public Exchange exchange;
    public static final String convertID = "Convert";
    public static final String rateID = "Add New Rate";
    
    JFrame mainFrame ;
    JPanel boxPanel;
    JPanel livrePanel;
    JPanel euroPanel;
    GridLayout gridLayout;
    JLabel livreLabel;
    JLabel euroLabel;
    JLabel dollarEqualsLabel;
    JLabel dollarEqualsLabel2;
    JTextArea livreTextArea;
    JTextArea euroTextArea;
    
    JButton addNewRate;
    JButton convert; 
    
    JPanel buttonAddPanel;
    JPanel buttonconvertPanel;
    JPanel amountToConvertPanel;
    JPanel amountToConvertPanel2;
    
    JLabel amountToConvertLabel;
    
    JPanel amountToConvertPanelTextArea;
    JTextArea amountToConvertTextArea;
    public static double amount=0;
    
    public View1(Exchange e){
        this();
        this.exchange = e;
    }
    public  View1(){
        mainFrame = new JFrame();
        boxPanel = new JPanel();
        gridLayout = new GridLayout(6,0);
        boxPanel.setLayout(gridLayout);
        mainFrame.add(boxPanel);
                
                
        dollarEqualsLabel  = new JLabel("1 $=");
        dollarEqualsLabel2  = new JLabel("1 $=");
        livreLabel = new JLabel("LL");
        euroLabel = new JLabel("Euro");
        
        livreTextArea = new JTextArea(1,10);
        euroTextArea  = new JTextArea(1,10);
        
        livrePanel = new JPanel();
        euroPanel = new JPanel();
        
        livrePanel.add(dollarEqualsLabel);
        livrePanel.add(livreTextArea);
        livrePanel.add(livreLabel);
        
        euroPanel.add(dollarEqualsLabel2);
        euroPanel.add(euroTextArea);
        euroPanel.add(euroLabel);
        
        
        boxPanel.add(livrePanel);
        boxPanel.add(euroPanel);
        
        buttonAddPanel = new JPanel(new FlowLayout());
        addNewRate = new JButton("Add New Rate");
        buttonAddPanel.add(addNewRate);
        boxPanel.add(buttonAddPanel);
        
        amountToConvertPanel = new JPanel(new FlowLayout());
        amountToConvertLabel = new JLabel("Amount $ To Convert");
        amountToConvertPanel.add(amountToConvertLabel);
        boxPanel.add(amountToConvertPanel);

        
        amountToConvertPanelTextArea = new JPanel();
        amountToConvertTextArea = new JTextArea(1,10);
        amountToConvertPanelTextArea.add(amountToConvertTextArea);
        boxPanel.add(amountToConvertPanelTextArea);
        
        buttonconvertPanel = new JPanel();
        convert = new JButton("Convert");
        buttonconvertPanel.add(convert);
        boxPanel.add(buttonconvertPanel);
        
        convert.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent ae) {
                clickedConvert();
            }

       
        
        });
        
        addNewRate.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent ae) {
                clickedRate();
            }

           
        
        
        });
        
        
        
        
        
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setSize(300, 300);
        
    }
    
     private void clickedConvert() {
//           new View2();  
         String stringAmount = this.amountToConvertTextArea.getText();
         try{
               amount = Double.parseDouble(stringAmount);
               exchange.workTheObs();
             
         }catch(Exception e){
             System.out.println("Error");
         }
    }
    private void clickedRate() {
 
        try{
            
               double llAmount = Double.parseDouble(livreTextArea.getText());
               double euroAmount = Double.parseDouble(euroTextArea.getText());
               
               
           
               
               
               if(llAmount > 0){
                   exchange.modifyCurrency(livreLabel.getText(),llAmount);
                   System.out.println("gayaret l LL");
               }else {  
                    System.out.println("no negative in ll");
               }
               
               if(euroAmount >0 ){
                   exchange.modifyCurrency(euroLabel.getText(), euroAmount);
                   System.out.println("gayaret l euro");
               }else {
                 System.out.println("no negative in euro"); 
               }
            
               
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(" only numbers allowed in input");
        }
    }
    
}
