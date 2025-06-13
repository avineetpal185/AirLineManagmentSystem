
package airlinemanagment.system;
import java.awt.*; // used for color 
import  javax.swing.*;
import java.awt.event.*; //for ActionListener interface
import java.sql.*;


public class Login extends JFrame implements ActionListener { //if any class have startigng with J it means that was class of Swing 
    
    //Declaring button globally so i can work on it in ActionListener class
    JButton submit,reset,close;
    // declaring input stream globally so i can reset it when i click on reset button
    JTextField user;
    JPasswordField pass;
    
    
    Login(){
        //now we create frame
        //if we want to change/work on frame we have to get the full frame
        getContentPane().setBackground(Color.WHITE);
        //now we dont want to use default Layout we create our Laoyut
        setLayout(null);
        //now to write anything on frame
        JLabel lblLogin = new JLabel("Username");
        // now to set the top written text on frame by creating our own layout
        lblLogin.setBounds(20, 20, 100, 20);   //left,top,length of text/varaiable etc,height
         add(lblLogin); // to show this text on the frame/screen
         //now we create the text where user cna write their name
          user = new JTextField(); // this class used to add text keypad
         user.setBounds(130, 20, 200, 20); 
         add(user); // adding keypad on screen
         
        JLabel lblPass = new JLabel("Password");
        lblPass.setBounds(20, 60, 100, 20);   
         add(lblPass); 
         
           pass = new JPasswordField(); // this class used to add text keypad
         pass.setBounds(130, 60, 200, 20); 
         add(pass); // adding keypad on screen
         
         
         //now we will create button
          reset = new JButton("Reset");
         reset.setBounds(40, 120, 120, 20);
         //adding action in button so specific btoon we perform the specific work
         reset.addActionListener(this); // passing th refrence of this class 
         add(reset);
         
            submit = new JButton("Submit");
         submit.setBounds(190, 120, 120, 20);
           submit.addActionListener(this);
         add(submit);
         
            close  = new JButton("Close");
         close.setBounds(120, 160, 120, 20);
           close.addActionListener(this);
         add(close);
         
        setSize(400, 250);
        setLocation(1050,20);
        setVisible(true);
        
    }
    
    //overriding 1 method in ActionListener class
    public void actionPerformed(ActionEvent ae){
        // the action to be performed here what button do on press
        if(ae.getSource() == submit){ // getSource tell the source that this source trigger from which button
            //below fetching the values from (user (textfield) and storing in String
            String username = user.getText();
            String password = pass.getText();
            try{
                //insode this calling our database
                //below calling con class
                con c = new con();
                //below is query to fetch username and password
                //below +username+ which user enter and match that username with databse (stored data)
                //single comma use becaue Varchhar value always store with string
                String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
                //below line execute query written top
                //below line used For ddl command (when you are fetching the data from the database)
               ResultSet rs = c.s.executeQuery(query); //giving (query) written above
               if(rs.next()){  //below this check user valid or not 
                   new Home();
                   setVisible(false);
               }else{
                   JOptionPane.showMessageDialog(null, "Invalid Username or password");
                   setVisible(false);
               }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == close){
            setVisible(false); // to close the frame 
            
        }else if(ae.getSource() == reset){
            // to remove the data from the textbar
            user.setText(""); // empty it
            pass.setText(""); // empty the password
            
        }
        
    }
    
    public static void main(String[] args){
        Login l = new Login(); //or you can create like this (new Login()<-- like this if you dont want to store any value in this)
        
    }
    
}