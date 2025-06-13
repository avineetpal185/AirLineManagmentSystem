package airlinemanagment.system;

import javax.swing.*; //JFrame class present in this swing
import java.awt.*; //color class present in this 
import java.awt.event.*; //for ActionListner
import java.sql.*; // for resultSet class during fetching the data form the databaase
import java.util.*; //for Random class to store the final data
public class BoardingPass extends JFrame implements ActionListener { //JFrame class is used to create the frame
    //why when we implement interface ActionListner error comes in Addcustomer class,bec java has rule
    //when we implementing interface we have to override method inside interface or make the class abstract
    //if we make our class abstract then we cannot create their varaible
    
      //createing all textfield varibales globally so we can fetch the data from it 
    JTextField   tfpnr ;
    //i need lable for Name in this page
    JLabel tfname , tfnationality, lblsrc , lbldest, labelflname,labelfcode, labeldate;
    JButton  fetchButton ;
  ;
    
    
    public BoardingPass(){
        
        //layout designing
        getContentPane().setBackground(Color.WHITE);
        //null the bydefault Layout
        setLayout(null);
        
        //Creating the Heading
        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380, 10, 450, 35 );
        //increasing the langth of heading
        heading.setFont(new Font("Tahoma", Font.BOLD, 32));
        add(heading);
        
        
         //Creating the Heading
        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(360, 50, 300, 30 );
        //increasing the langth of heading
        subheading.setFont(new Font("Tahoma", Font.BOLD, 24));
        //changin heading color
        subheading.setForeground(Color.BLUE);
        add(subheading);
        
        
        
        
              //Taking customer addhar
        JLabel lbladdhar = new JLabel("PNR DETAILS");
        lbladdhar.setBounds(60, 100, 150, 25 );
        //increasing the langth of heading
        lbladdhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdhar);
        //now we want text where user can enter their name
        
         tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);
        
        //user enter their addhar becaue it is unique and then with help of addhar we fetch the imf other about user
         fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 100, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
          //Taking customer name
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 140, 150, 25);
        //increasing the langth of heading
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        //now we want text where user can enter their name
        
         tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        add(tfname);
        
           //Taking customer nationality
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 180, 150, 25 );
        //increasing the langth of heading
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        //now we want text where user can enter their name
        
         tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
        
        
       
        
               //Taking customer address
        JLabel lbladdress = new JLabel("SRC");
        lbladdress.setBounds(60, 220, 150, 25 );
        //increasing the langth of heading
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        //now we want text where user can enter their name
        
         lblsrc = new JLabel();
        lblsrc.setBounds(220, 220, 150, 25);
        add(lblsrc );
        
        
                 //Taking customer gender
        JLabel lblgender = new JLabel("DEST");
        lblgender.setBounds(380, 220, 150, 25 );
        //increasing the langth of heading
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
                      //Taking customer gender
         lbldest = new JLabel();
        lbldest.setBounds(540, 220, 150, 25 );
        add(lbldest);
        
        
       
        
         JLabel lblflname = new JLabel("Flight Name");
        lblflname.setBounds(60, 260, 150, 25 );
        //increasing the langth of heading
        lblflname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblflname);
        //now we want text where user can enter their name
        
         labelflname = new JLabel();
        labelflname.setBounds(220, 260, 150, 25);
        add(labelflname);
        
        
       
        
         JLabel lblfcode = new JLabel("Flight Code");  // present in database flight code 1001, etc
        lblfcode.setBounds(380, 260, 150, 25 );
        //increasing the langth of heading
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        //now we want text where user can enter their name
        
         labelfcode = new JLabel();
        labelfcode.setBounds(540, 260, 150, 25);
        add(labelfcode );
        
        
        
          JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 300, 150, 25 );
        //increasing the langth of heading
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        //now we want text where user can enter their name
        
          labeldate= new JLabel(); //create the calendar object which we ownlaod from googleDrive
        labeldate.setBounds(220, 300, 150, 25);
        add(labeldate );
        
        
        
        
        
        //now we will add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagment/system/icons/airindia.png"));
        //decerasing the size of image
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        //You cannot directly put this image you put other object tyhrn yu can use this feature or image
        ImageIcon image = new ImageIcon(i2);
        
        
        //adding this in JLabel
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 0, 300, 300);
        //now adding image
        add(lblimage);
        
        
      
        
        setSize(1000, 450);
        setLocation(300, 150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        //now we fetch the all data from the different text field and store it here
      
   //we fetch the dtaa on base of Addhar number
        String pnr =tfpnr.getText();
        
        try{
            con Con = new con(); //calling other connection class
            
            
            String query = "select * from reservation where PNR = '"+pnr+"'"; // selecting data from the addhar
            //this is Dml command we are isnerting the values
            //below query is used when we are inserting values
            ResultSet rs = Con.s.executeQuery(query); //rember Con is object of (con class)
            //above storing in ResultSet because it is a legal command
            //if your query successfully running then..
             if(rs.next()){
                // if addhar exist then we add the other data of user on bases of their addhar
                 tfname.setText(rs.getString("name"));
                  tfnationality.setText(rs.getString("nationality"));
                 lblsrc.setText(rs.getString("src"));
                  lbldest.setText(rs.getString("des"));
                 labelflname.setText(rs.getString("flightname"));
                 labelfcode.setText(rs.getString("flightcode"));
                 labeldate.setText(rs.getString("ddate")); 
              
                
            }else{
                // if user not exist on base of addhar
                 JOptionPane.showMessageDialog(null, "Please enter the correct PNR");
            }
                   
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    
     
              
              
    }
    
    
    public static void main(String[] args){
        new BoardingPass();
    }
}
