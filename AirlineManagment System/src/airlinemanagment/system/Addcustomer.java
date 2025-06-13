package airlinemanagment.system;

import javax.swing.*; //JFrame class present in this swing
import java.awt.*; //color class present in this 
import java.awt.event.*; //for ActionListner

public class Addcustomer extends JFrame implements ActionListener { //JFrame class is used to create the frame
    //why when we implement interface ActionListner error comes in Addcustomer class,bec java has rule
    //when we implementing interface we have to override method inside interface or make the class abstract
    //if we make our class abstract then we cannot create their varaible
    
    
    
    //createing all textfield varibales globally so we can fetch the data from it 
    JTextField tfname, tfphone, tfaddhar, tfnationality, tfaddress;
    //now for radio button
    JRadioButton rbmale, rbfemale;
    public Addcustomer(){
        
        //layout designing
        getContentPane().setBackground(Color.WHITE);
        //null the bydefault Layout
        setLayout(null);
        
        //Creating the Heading
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220, 20, 500, 35 );
        //increasing the langth of heading
        heading.setFont(new Font("Tahoma", Font.BOLD, 32));
        //changin heading color
        heading.setForeground(Color.BLUE);
        add(heading);
        
          //Taking customer name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25 );
        //increasing the langth of heading
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        //now we want text where user can enter their name
        
         tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        add(tfname);
        
           //Taking customer nationality
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 130, 150, 25 );
        //increasing the langth of heading
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        //now we want text where user can enter their name
        
         tfnationality = new JTextField();
        tfnationality.setBounds(220, 130, 150, 25);
        add(tfnationality);
        
        
             //Taking customer addhar
        JLabel lbladdhar = new JLabel("Addhar Number");
        lbladdhar.setBounds(60, 180, 150, 25 );
        //increasing the langth of heading
        lbladdhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdhar);
        //now we want text where user can enter their name
        
         tfaddhar = new JTextField();
        tfaddhar.setBounds(220, 180, 150, 25);
        add(tfaddhar);
        
               //Taking customer address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25 );
        //increasing the langth of heading
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        //now we want text where user can enter their name
        
         tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress );
        
        
                 //Taking customer gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25 );
        //increasing the langth of heading
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        //make code only male or female one selct both cannot be seleted
        ButtonGroup gendergroup = new ButtonGroup();
        //after this add both male and female radio button inside it (down inside
        
        //Now we want radio button to store
         rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 280, 70, 25);
        //to remove background behind radio button
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
         rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 280, 70, 25);
         rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        //insiding both radio button ButtonGroup class
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
         
               //Taking customer phone no
        JLabel lblPhone = new JLabel("Phone No");
        lblPhone.setBounds(60, 330, 150, 25 );
        //increasing the langth of heading
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblPhone);
        //now we want text where user can enter their name
        
         tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);
        
        //now creating save button
        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220, 380, 150, 30);
        //now we will the ActionListner (so we understand at which button we want action)
        save.addActionListener(this);
        add(save);
        
        //now we will add image
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagment/system/icons/emp.png"));
        //adding this in JLabel
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 80, 280, 400);
        //now adding image
        add(lblimage);
        
        
        
        
        
        
        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        //now we fetch the all data from the different text field and store it here
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String Phone = tfphone.getText();
        String address = tfaddress.getText();
        String addhar =tfaddhar.getText();
        //for radio button
        String gender = null;
        if(rbmale.isSelected()){
            gender = "Male";
        }else {
            gender ="Female";
        }
        
        try{
            con Con = new con(); //calling other connection class
            
            
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+Phone+"', '"+address+"', '"+addhar+"', '"+gender+"')";
            //this is Dml command we are isnerting the values
            //below query is used when we are inserting values
            Con.s.executeUpdate(query); //rember Con is object of (con class)
            //if your query successfully running then..
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            //when our values are stored we have to close it
            setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    public static void main(String[] args){
        new Addcustomer();
    }
}
