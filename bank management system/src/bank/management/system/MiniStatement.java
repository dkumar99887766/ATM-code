package bank.management.system;
import java.awt.Color;
import javax.swing.*;    
import java.sql.*;

public class MiniStatement extends JFrame  {
    
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(100,20,100,20);
        add(bank);
        
         JLabel card = new JLabel();
        card.setBounds(10,80,300,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(10,300,300,20);
        add(balance);
        
        try{
            conn conn = new conn();
           
            ResultSet rs =conn.s.executeQuery("select * from login where pin ='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" +rs.getString("cardnumber").substring(12) );
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            conn conn = new conn();
            int bal =0;
            ResultSet rs =conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
              
              if(rs.getString("type").equals("Deposit")){
                          bal +=Integer.parseInt( rs.getString("amount"));
                      }else{
                          bal -=Integer.parseInt( rs.getString("amount"));
                      }  

            }
            balance.setText("Your Current Account balance is Rs " + bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
        
        
        setSize(300,500);
        setLocation(10,10);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);                                                                                   
    }
    
    
  public static void main(String[] args){
      new MiniStatement("");
      
  }    
}
