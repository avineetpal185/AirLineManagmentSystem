package airlinemanagment.system;

import javax.swing.*; //JFrame class present in this swing
import java.awt.*; //color class present in this 
import java.awt.event.*; //for ActionListner
import java.sql.*; // for resultSet class during fetching the data form the databaase
import java.util.*; //for Random class to store the final data
public class Cancel extends JFrame implements ActionListener { //JFrame class is used to create the frame
    //why when we implement interface ActionListner error comes in Addcustomer class,bec java has rule
    //when we implementing interface we have to override method inside interface or make the class abstract
    //if we make our class abstract then we cannot create their varaible
    
      //createing all textfield varibales globally so we can fetch the data from it 
    JTextField   tfpnr ;
    //i need lable for Name in this page
    JLabel tfname , cancellationno, lblfcode , lbldateoftravel;
    JButton  fetchButton, flight ;

    //
    
    public Cancel(){
        
        //layout designing
        getContentPane().setBackground(Color.WHITE);
        //null the bydefault Layout
        setLayout(null);
        
        
        // for generating the Cancellation Number
        // by help of random class we can genrate random numbers
        Random random = new Random();
        
        
        //Creating the Heading
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(180, 20, 250, 35 );
        //increasing the langth of heading
        heading.setFont(new Font("Tahoma", Font.BOLD, 32));
        add(heading);
        
        //GOING TO add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagment/system/icons/cancel.jpg"));
        //image i very big so we have to reduce their size
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470, 120, 250, 250);
        add(image);
        
              //No we take the pNr number for the cancellation
        JLabel lbladdhar = new JLabel("PNR CANCELLATION ");
        lbladdhar.setBounds(60, 80, 150, 25 );
        //increasing the langth of heading
        lbladdhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdhar);
        //now we want text where user can enter their name
        
         tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);
        
       //when user enter pNr number we want the details on click of button 
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
          //PNR-I want Name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        //increasing the langth of heading
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        //now we want text where user can enter their name
        
         tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
           //Cnacelltion no->is unique no when you cancle the ticket it used for future perspective
        JLabel lblnationality = new JLabel("Cnacellation no");
        lblnationality.setBounds(60, 180, 150, 25 );
        //increasing the langth of heading
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        //now we want text where user can enter their name
        
        // we want 6 diti cancellation no automatically generate by hlep of Rnadom class near constructor declared
         cancellationno = new JLabel("" + random.nextInt(1000000));
         //above giving "" JLable accept string not Int sp that why change their type
        cancellationno.setBounds(220, 180, 150, 25);
        add(cancellationno);
        
        
       
        
               // Flight code which flight you are cancelling their code->come form database
        JLabel lbladdress = new JLabel("Flight Code");
        lbladdress.setBounds(60, 230, 150, 25 );
        //increasing the langth of heading
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        //now we want text where user can enter their name
        
         lblfcode = new JLabel();
        lblfcode.setBounds(220, 230, 150, 25);
        add(lblfcode );
        
        
                 //at which Date you are travelling
        JLabel lblgender = new JLabel("Date");
        lblgender.setBounds(60, 280, 150, 25 );
        //increasing the langth of heading
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
                      //Taking customer gender
         lbldateoftravel = new JLabel();
        lbldateoftravel.setBounds(220, 280, 150, 25 );
        add(lbldateoftravel);


     //creatin button which tells the source and destination which select that flight exist or not
         flight = new JButton("Cancel");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(220, 330, 120, 25); //adding the button font in desitnation
        //now we will the ActionListner (so we understand at which button we want action)
        flight.addActionListener(this);
        add(flight);
        
        
        
        
        
        setSize(800, 450);
        setLocation(350, 150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == fetchButton){
        //now we fetch the all data from the different text field and store it here
      
   //we fetch the dtaa on base of Addhar number
        String pnr =tfpnr.getText();
        
        try{
            con Con = new con(); //calling other connection class
            
            
            String query = "select * from reservation where PNR = '"+pnr+"'"; // selecting data from the pnr
            //this is Dml command we are isnerting the values
            //below query is used when we are inserting values
            ResultSet rs = Con.s.executeQuery(query); //rember Con is object of (con class)
            //above storing in ResultSet because it is a legal command
            //if your query successfully running then..
            if(rs.next()){
                // if addhar exist then we add the other data of user on bases of their addhar
                 tfname.setText(rs.getString("name"));
                 lblfcode.setText(rs.getString("flightcode"));
                 lbldateoftravel.setText(rs.getString("ddate")); 
              
                
            }else{
                // if user not exist on base of addhar
                 JOptionPane.showMessageDialog(null, "Please enter the correct PNR");
            }
                   
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
        //Now for the else ->For souce and destination
        else
              if(ae.getSource() == flight){ // if ae get soruce equal to flight(button)
        //now we fetch the all data from the different text field and store it here
      
   //we fetch the dtaa on base of name and pnr number
        String name = tfname.getText(); // because source have drop down multiple options
        String pnr = tfpnr.getText();
        String cancelno = cancellationno.getText();
        String fcode = lblfcode.getText();
        String date = lbldateoftravel.getText();
        
        try{
            con Con = new con(); //calling other connection class
            
            
            String query = "insert into cancel values('"+pnr+"', '"+name+"','"+cancelno+"', '"+fcode+"', '"+date+"')"; 
          //cancel table data add the cancel ticket data
             Con.s.executeUpdate(query); //rember Con is object of (con class)
             //removing data from reservation table in database
             Con.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
             JOptionPane.showMessageDialog(null, "Ticket Cancelled");
             setVisible(false);
            
                   
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    }
    
    
    public static void main(String[] args){
        new Cancel();
    }
}
