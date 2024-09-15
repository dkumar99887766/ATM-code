package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
      JButton back;
      String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;
//        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3  = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(270,415,120,25);
        back.addActionListener(this);
        image.add(back);
        
         conn c = new conn();
           int balance =0;
              try{
                  ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                 
                  while(rs.next()){
                      if(rs.getString("type").equals("Deposit")){
                          balance +=Integer.parseInt( rs.getString("amount"));
                      }else{
                          balance -=Integer.parseInt( rs.getString("amount"));
                      }
                  }
                }catch(Exception e){
                  System.out.println(e);
                }
        
        JLabel text = new JLabel("Your Current Account balance is Rs "+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(120,230,400,30);
        image.add(text);
        
        setSize(700,700);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
//        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
               
    }
    
    
    public static void main(String[] args){
        new BalanceEnquiry("");
    }
}
