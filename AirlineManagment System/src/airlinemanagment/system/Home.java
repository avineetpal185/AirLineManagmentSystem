
package airlinemanagment.system;
import java.awt.*; // used for color 
import  javax.swing.*;
import java.awt.event.*; //for ActionListener interface
import java.sql.*;


public class Home extends JFrame implements ActionListener { //if any class have startigng with J it means that was class of Swing 
    
   
    
     Home(){
      
        //now we dont want to use default Layout we create our Laoyut
        setLayout(null);
        //now we add the big image on our frame(aeroplane)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagment/system/icons/front.jpg"));
        //now we add our top image on frame you cannot use directly add function
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1600, 800);
        add(image);
        
        //now we write text above on image
        JLabel heading = new JLabel("AIR INDIAN WECOME YOU");
        heading.setBounds(500, 40, 1000, 40); //set the location on fraem 
        //we will change the color
        heading.setForeground(Color.red);
        //now we change their font
        heading.setFont(new Font("Tahoma", Font.PLAIN, 36)); //font family,font type(italic etc), font size
        //now i have to show this heading on top of image
        //now use add become add become add the text on frame and on the frame image is add so we have to add on image
        image.add(heading);
        
        //now we will create the menu
        // to create menu we use JMenuBar class
        JMenuBar menubar = new JMenuBar();
        //adding/setting menubar
        setJMenuBar(menubar);
        //now we are adding our 1st menu (details)
        JMenu details = new JMenu("Details");
        //adding detail menubar
        menubar.add(details);
        
        //when we click on menu drop down list come
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        //when click on this our new page open
        flightDetails.addActionListener(this);
        //adding the above menu/option in detail (menu which we created )
        details.add(flightDetails);
        
         JMenuItem customerDetails = new JMenuItem("Add Customer Details");
         //when click on this optin click the new page (when we created already)
         customerDetails.addActionListener(this);
        details.add(customerDetails);
        
         JMenuItem bookFlight = new JMenuItem("Book Flight");
         bookFlight.addActionListener(this);
        details.add(bookFlight);
        
         JMenuItem journeyDetails = new JMenuItem("Journey Details");
            journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
         JMenuItem ticketCancellation = new JMenuItem("Ticket Cancellation");
         ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
        JMenu ticket = new JMenu("Ticket ");
        menubar.add(ticket);
        
        JMenuItem bordingPass = new JMenuItem("Boarding Pass");
         bordingPass.addActionListener(this);
        ticket.add(bordingPass);
        
        
       
 
        setExtendedState(JFrame.MAXIMIZED_BOTH); //maximed both increase the size of frame accoring to screen length
       
        setVisible(true);
        
    }
    
   
    public void actionPerformed(ActionEvent ae){
        //now we check which option called here
        String text = ae.getActionCommand(); // they tell the action
        if (text.equals("Add Customer Details")){
            new Addcustomer();
            
        } else if (text.equals("Flight Details")){
            new FlightInfo();
        }
        else if (text.equals("Book Flight")){
            new BookFlight();
        }
        else if(text.equals("Journey Details")){
            new JourneyDetails();
        }
        else if(text.equals("Ticket Cancellation")){
            new Cancel();
        }
        else if(text.equals("Boarding Pass")){
            new BoardingPass();
        }
    }
    
    
    public static void main(String[] args){
         Home hi = new Home();         
    }
    
}