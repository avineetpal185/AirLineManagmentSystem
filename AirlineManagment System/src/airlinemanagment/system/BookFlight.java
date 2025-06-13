package airlinemanagment.system;

import javax.swing.*; //JFrame class present in this swing
import java.awt.*; //color class present in this 
import java.awt.event.*; //for ActionListner
import java.sql.*; // for resultSet class during fetching the data form the databaase
import com.toedter.calendar.JDateChooser; // it is class present in our calendar which we downlaod from the googleDrive
import java.util.*; //for Random class to store the final data
public class BookFlight extends JFrame implements ActionListener { //JFrame class is used to create the frame
    //why when we implement interface ActionListner error comes in Addcustomer class,bec java has rule
    //when we implementing interface we have to override method inside interface or make the class abstract
    //if we make our class abstract then we cannot create their varaible
    
      //createing all textfield varibales globally so we can fetch the data from it 
    JTextField   tfaddhar ;
    //i need lable for Name in this page
    JLabel tfname , tfnationality, tfaddress , labelgender, labelflname,labelfcode;
    JButton bookflight, fetchButton, flight ;
    Choice source,destination;
    JDateChooser dcdate;
    //
    
    public BookFlight(){
        
        //layout designing
        getContentPane().setBackground(Color.WHITE);
        //null the bydefault Layout
        setLayout(null);
        
        //Creating the Heading
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420, 20, 500, 35 );
        //increasing the langth of heading
        heading.setFont(new Font("Tahoma", Font.BOLD, 32));
        //changin heading color
        heading.setForeground(Color.BLUE);
        add(heading);
        
              //Taking customer addhar
        JLabel lbladdhar = new JLabel("Addhar ");
        lbladdhar.setBounds(60, 80, 150, 25 );
        //increasing the langth of heading
        lbladdhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdhar);
        //now we want text where user can enter their name
        
         tfaddhar = new JTextField();
        tfaddhar.setBounds(220, 80, 150, 25);
        add(tfaddhar);
        
        //user enter their addhar becaue it is unique and then with help of addhar we fetch the imf other about user
         fetchButton = new JButton("Fetch User");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
          //Taking customer name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        //increasing the langth of heading
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        //now we want text where user can enter their name
        
         tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
           //Taking customer nationality
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 180, 150, 25 );
        //increasing the langth of heading
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        //now we want text where user can enter their name
        
         tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
        
        
       
        
               //Taking customer address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25 );
        //increasing the langth of heading
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        //now we want text where user can enter their name
        
         tfaddress = new JLabel();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress );
        
        
                 //Taking customer gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25 );
        //increasing the langth of heading
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
                      //Taking customer gender
         labelgender = new JLabel("Gender");
        labelgender.setBounds(220, 280, 150, 25 );
        add(labelgender);
        
          JLabel lblsource = new JLabel("Source"); // it is text
        lblsource.setBounds(60, 330, 150, 25 );
        //increasing the langth of heading
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);
        
        //creating dropdwon in which we cna slect our source
         source = new Choice();
        source.setBounds(220, 330, 150, 25); // this add the drop down option
        // how to add values in this dropdown option
        
        add(source);
        
        
          JLabel lbldestination = new JLabel("Destination"); // it is text
        lbldestination.setBounds(60, 380, 150, 25 );
        //increasing the langth of heading
        lbldestination.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldestination);
        
        
        //creating dropdwon in which we cna slect our source
         destination = new Choice();
        destination.setBounds(220, 380, 150, 25); // this add the drop down option
        // how to add values in this dropdown option
        
        add(destination);  
        
        
        //calling im mysql for data
        try{
            //calling in database
            con Con = new con();
            //now creating query for it
            String query = "select * from flight";
            ResultSet rs = Con.s.executeQuery(query);
            
            //now getting data 
            while(rs.next()) { // if 10 row fetched rs.next come row one by one
                source.add(rs.getString("source")); // now geetting only source and adding it in source object which we created
                destination.add(rs.getString("destination")); // adding destination from data base in destination object which we created
                
                
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        //creatin button which tells the source and destination which select that flight exist or not
         flight = new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380, 380, 120, 25); //adding the button font in desitnation
        //now we will the ActionListner (so we understand at which button we want action)
        flight.addActionListener(this);
        add(flight);
        
        
         JLabel lblflname = new JLabel("Flight Name");
        lblflname.setBounds(60, 430, 150, 25 );
        //increasing the langth of heading
        lblflname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblflname);
        //now we want text where user can enter their name
        
         labelflname = new JLabel();
        labelflname.setBounds(220, 430, 150, 25);
        add(labelflname);
        
        
       
        
         JLabel lblfcode = new JLabel("Flight Code");  // present in database flight code 1001, etc
        lblfcode.setBounds(60, 480, 150, 25 );
        //increasing the langth of heading
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        //now we want text where user can enter their name
        
         labelfcode = new JLabel();
        labelfcode.setBounds(220, 480, 150, 25);
        add(labelfcode );
        
        
        
          JLabel lbldate = new JLabel("Date Of Travel");
        lbldate.setBounds(60, 530, 150, 25 );
        //increasing the langth of heading
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        //now we want text where user can enter their name
        
          dcdate= new JDateChooser(); //create the calendar object which we ownlaod from googleDrive
        dcdate.setBounds(220, 530, 150, 25);
        add(dcdate );
        
        
        
        
        
        //now we will add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagment/system/icons/details.jpg"));
        //decerasing the size of image
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        //You cannot directly put this image you put other object tyhrn yu can use this feature or image
        ImageIcon image = new ImageIcon(i2);
        
        
        //adding this in JLabel
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 80, 500, 410);
        //now adding image
        add(lblimage);
        
        
        //creatin button which tells the source and destination which select that flight exist or not
         bookflight = new JButton("Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(220, 580, 150, 25); //adding the button font in desitnation
        //now we will the ActionListner (so we understand at which button we want action)
        bookflight.addActionListener(this);
        add(bookflight);
        
        
        
        
        setSize(1100, 700);
        setLocation(200, 50);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == fetchButton){
        //now we fetch the all data from the different text field and store it here
      
   //we fetch the dtaa on base of Addhar number
        String addhar =tfaddhar.getText();
        
        try{
            con Con = new con(); //calling other connection class
            
            
            String query = "select * from passenger where aadhar = '"+addhar+"'"; // selecting data from the addhar
            //this is Dml command we are isnerting the values
            //below query is used when we are inserting values
            ResultSet rs = Con.s.executeQuery(query); //rember Con is object of (con class)
            //above storing in ResultSet because it is a legal command
            //if your query successfully running then..
            if(rs.next()){
                // if addhar exist then we add the other data of user on bases of their addhar
                 tfname.setText(rs.getString("name"));
                 tfnationality.setText(rs.getString("nationality"));
                 tfaddress.setText(rs.getString("address")); 
                 labelgender.setText(rs.getString("gender"));
                 
                
            }else{
                // if user not exist on base of addhar
                 JOptionPane.showMessageDialog(null, "Please enter the correct addhar");
            }
                   
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
        //Now for the else ->For souce and destination
        else
              if(ae.getSource() == flight){ // if ae get soruce equal to flight(button)
        //now we fetch the all data from the different text field and store it here
      
   //we fetch the dtaa on base of source and destination number
        String src = source.getSelectedItem(); // because source have drop down multiple options
        String dest = destination.getSelectedItem();
        
        try{
            con Con = new con(); //calling other connection class
            
            
            String query = "select * from flight where source = '"+src+"' and destination = '"+dest+"'"; 
            //this is Dml command we are isnerting the values
            //below query is used when we are inserting values
            ResultSet rs = Con.s.executeQuery(query); //rember Con is object of (con class)
            //above storing in ResultSet because it is a legal command
            //if your query successfully running then..
            if(rs.next()){
                // if that flight and flight code exist in database it fetch it here
                 labelflname.setText(rs.getString("f_name"));
                 labelfcode.setText(rs.getString("f_code"));
                
                
            }else{
                // if no flight exists
                 JOptionPane.showMessageDialog(null, "No Flights Found");
            }
                   
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }else{
Random random = new Random ();
//fetching the all information for the final button (BOOK FLIGHT) sotre final data
//createing all textfield varibales globally so we can fetch the data from it 
String aadhar = tfaddhar.getText() ;
String name = tfname.getText();
String nationality =tfnationality.getText();
String Address = tfaddress.getText();
String Labelgender = labelgender.getText();
String flightname = labelflname.getText();
String flightcode = labelfcode.getText();
String src =  source.getSelectedItem();
String dest =destination.getSelectedItem();
// to get the date from calendar it little bit complex
// it basically function running here you have to 1st pick the Editor,then its UI component,now the text written on them
//byt hetText not work , so you have to conver this package in innerTextField so we type cast ir
    String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
              
               try{
            con Con = new con(); //calling other connection class
            
            // it generate the random PNR no which is of 6 digit and same for TIC but for 4 number
            String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', '"+aadhar+"', '"+name+"', '"+nationality+"', '"+flightname+"', '"+flightcode+"', '"+src+"', '"+dest+"', '"+ddate+"') "; 
           
             Con.s.executeUpdate(query); //rember Con is object of (con class)
       
            //if your query successfully running then..
           
                 JOptionPane.showMessageDialog(null, "Ticket Bokked Succesfully");
                 // after ticket book we have to close the frame
                 setVisible(false);
            
                   
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
              
              
              }
    }
    
    
    public static void main(String[] args){
        new BookFlight();
    }
}
