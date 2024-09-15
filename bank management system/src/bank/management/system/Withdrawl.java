

package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class Withdrawl extends JFrame implements ActionListener {
    JButton Withdraw,back;
    JTextField amount;
    String pinnumber;
    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3  = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to Withdraw"); 
        text.setBounds(160,245,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,12));
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,18 ));
        amount.setBounds(150,300,230,20);
        image.add(amount);
        
        Withdraw = new JButton("Withdraw");
        Withdraw.setBounds(270,405,130,25);
        Withdraw.addActionListener(this);
        image.add(Withdraw);
        
        back = new JButton("Back");
        back.setBounds(270,435,130,25);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(700, 700);
        setLocation(300, 0);
//      setUndecorated(true);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
          if(ae.getSource()== Withdraw){
              String number = amount.getText();
              Date date = new Date();
              if(number.equals("")){
                  JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw");
                  
              }else{
                  try{
                  conn conn = new conn();
                  String query ="insert into bank values('"+pinnumber +"','"+date +"','Withdraw','"+number+"')";
                  conn.s.executeUpdate(query);    
                   JOptionPane.showMessageDialog(null,"Rs "+number+" Withdraw Successfully");
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
                  }catch(Exception e){
                      System.out.println(e);
                  }
                  
              }
          }else if(ae.getSource()== back ){
              setVisible(false);
              new Transactions(pinnumber).setVisible(true);
          }
     }
    public static void main(String[] args){
        new Withdrawl("");
    }
}
