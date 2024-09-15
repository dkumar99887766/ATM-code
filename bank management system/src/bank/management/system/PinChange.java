package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    
    JPasswordField pin,repin;
    JButton back,change;
    String pinnumber;
    
    PinChange(String pinnumber){
//        setLayout(null);
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3  = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
       
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(190,220,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,12));
        image.add(text);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,18 ));
        pin.setBounds(250,260,130,20);
        image.add(pin); 
        
        
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(130,260,500,25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,12));
        image.add(pintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,18 ));
        repin.setBounds(250,290,130,20);
        image.add(repin); 
        
        
        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setBounds(130,290,500,25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,12));
        image.add(repintext);
        
        back = new JButton("Back");
        back.setBounds(270,415,120,25);
        back.addActionListener(this);
        image.add(back);
        
        change = new JButton("CHANGE");
        change.setBounds(270,385,120,25);
        change.addActionListener(this);
        image.add(change);
        
        
         setSize(700, 700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
         public void actionPerformed(ActionEvent ae){
             if(ae.getSource() == change){
             try{
                 String npin = pin.getText();
                 String rpin = repin.getText();
                 if(!npin.equals(rpin)){
                     JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                     return;
                 }
               if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Entered new PIN");
                     return;
               }
              if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Entered new PIN");
                     return;
               } 
               
              conn conn = new conn();
              String query1 = "Update bank set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
              String query2 = "Update login set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
              String query3 = "Update signupthree set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
              
              conn.s.executeUpdate(query1);
              conn.s.executeUpdate(query2);
              conn.s.executeUpdate(query3);
             
               JOptionPane.showMessageDialog(null,"PIN Change successfully ");
               
               setVisible(false);
               new Transactions(rpin).setVisible(true);
               
              
             } catch(Exception e){
                 System.out.println(e);
             }
          }else {
                 setVisible(false);
                 new Transactions(pinnumber).setVisible(true);
             }
             
         }

    
    public static void main(String args[] ){
        new PinChange("").setVisible(true);
        
    }
}
