package bank.management.system;

 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
 
public class Login extends JFrame implements ActionListener{
      
    JButton login,login1,login2;
    JTextField cardtextfield;
    JPasswordField pintextfield;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
       ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
       Image i2= i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel label = new JLabel(i3);
       label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
         JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        cardtextfield = new JTextField();
        cardtextfield.setBounds(300,150,230,30);
        cardtextfield.setFont(new Font("Arial",Font.BOLD,14));
        add(cardtextfield);
        
         JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,40);
        add(pin);
        
        pintextfield = new JPasswordField();
        pintextfield.setBounds(300,220,230,30);
        pintextfield.setFont(new Font("Arial",Font.BOLD,14));
        add(pintextfield);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        login1 = new JButton("CLEAR");
        login1.setBounds(430,300,100,30);
        login1.setBackground(Color.BLACK);
        login1.setForeground(Color.white);
        login1.addActionListener(this);
        add(login1);
        
        login2 = new JButton("SIGN UP");
        login2.setBounds(300,350,230,30);
        login2.setBackground(Color.BLACK);
        login2.setForeground(Color.white);
        login2.addActionListener(this);
        add(login2);
        
        
        getContentPane().setBackground(Color.WHITE);
    setSize(800,480);
     setLocation(350,200);
    setUndecorated(true);
    setVisible(true);
   
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== login1 ){
            cardtextfield.setText("");
            pintextfield.setText("");
        }else if (ae.getSource()== login ){
            conn conn= new conn();
            String cardnumber =cardtextfield.getText();
            String pinnumber = pintextfield.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                
                ResultSet rs= conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource()== login2){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
  public static void main(String[] args){
      new Login();
      
      
  }  
            
    
}
