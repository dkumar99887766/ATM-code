
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener {
    JButton deposit,withdrawl,statement,pin,fastcash,balance,exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3  = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(170,245,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,12));
        image.add(text);
        
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(130,340,130,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(270,340,130,25);
         withdrawl.addActionListener(this);
        image.add(withdrawl);
         
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(130,370,130,25);
        fastcash.addActionListener(this);
        image.add(fastcash);
         
        statement = new JButton("Rs 2000");
        statement.setBounds(270,370,130,25);
        statement.addActionListener(this);
        image.add(statement);
        
         
        pin = new JButton("Rs 5000");
        pin.setBounds(130,405,130,25);
        pin.addActionListener(this);
        image.add(pin);
        
         
        balance = new JButton("Rs 10000");
        balance.setBounds(270,405,130,25);
        balance.addActionListener(this);
        image.add(balance);
         
         
        exit = new JButton("Back");
        exit.setBounds(270,435,130,25);
        exit.addActionListener(this);
        image.add(exit);
       
         
        
        setSize(700, 700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
         
    }
     public void actionPerformed(ActionEvent ae){
          if(ae.getSource()== exit){
              setVisible(false);
              new Transactions(pinnumber).setVisible(true);
          }else {
              String amount =((JButton)ae.getSource()).getText().substring(3);// Rs 500
              conn c = new conn();
              try{
                  ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                  int balance =0;
                  while(rs.next()){
                      if(rs.getString("type").equals("Deposit")){
                          balance +=Integer.parseInt( rs.getString("amount"));
                      }else{
                          balance -=Integer.parseInt( rs.getString("amount"));
                      }
                  }
                  if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                      JOptionPane.showMessageDialog(null, "Insufficient Balance");
                      return;
                  }
                  Date date = new Date();
                  String query ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                  c.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null, "Rs "+ amount +" Debited Successfully");
                  
                 setVisible(false);
                 new Transactions(pinnumber).setVisible(true);
              } catch(Exception e){
                  System.out.println(e);
              }
          }
     }
    
    
    public static void main(String[] args){
        new FastCash("");
    }
}
