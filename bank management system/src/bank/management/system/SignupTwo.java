package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
   
    JTextField pan, aadhar;
    JButton   next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion,category,occupation,education,income;
    String formno;
            
       SignupTwo(String formno) {
           this.formno= formno;

        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(290, 80, 400, 30);
        add(additionaldetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        String valreligion []={"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valreligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 400, 30);
        add(fname);
        String  valcategory []= {"General","Obc","Sc","St","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 400, 30);
        add(dob);

        String  incomecategory []= {"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
         income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 150, 30);
        add(gender);

       

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 315, 400, 30);
        add(email);
        
        String  educationvalue []= {"Non-Graduation","Graduate","Post-Graduation","Doctrate","Others"};
        education = new JComboBox(educationvalue);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        JLabel marital = new JLabel("Ocupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 400, 30);
        add(marital);

         String  occupationvalue []= {"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupation = new JComboBox(occupationvalue);
        occupation.setBounds(300, 395, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        

       
       

        JLabel Address = new JLabel("PAN Number:");
        Address.setFont(new Font("Raleway", Font.BOLD, 20));
        Address.setBounds(100, 440, 150, 30);
        add(Address);
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel city = new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 180, 30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 150, 30);
        add(state);

         syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
           
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
       
        
        
        JLabel pin = new JLabel("Existing Account:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 590, 180, 30);
        add(pin);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
           
        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);
        
       

        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 625, 80, 30);
        add(next);
        next.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }
       
       public void actionPerformed(ActionEvent ae){
           String sreligion =(String)religion.getSelectedItem();
           String scategory = (String)category.getSelectedItem();
           String sincome = (String)income.getSelectedItem();
           String seducation =(String)education.getSelectedItem();
              String soccupation =(String)occupation.getSelectedItem();
                 String seniorcitizen =null;
           if(eyes.isSelected()){
             seniorcitizen  = "Yes";
           }else if( sno.isSelected()){
               seniorcitizen = "NO";
           }
           
           String existingaccount = null;
           if(eyes.isSelected()){
               existingaccount="Yes";
               
           }else if(eno.isSelected()){
               existingaccount="No";
           }
           
           String span = pan.getText();
           String saadhar = aadhar.getText();
           
           
           try{
                   conn c= new conn();
                   String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+existingaccount+"','"+seniorcitizen+"')";
                   c.s.executeUpdate(query);
                 
                   // signup 3 to can object create 
                   setVisible(false);
                   new SignupThree(formno).setVisible(true);
                   
           }catch(Exception e){
               System.out.println(e);
           }
           
       }
        

    public static void main(String[] args) {
        new SignupTwo("");
    }
}

