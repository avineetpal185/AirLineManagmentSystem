package airlinemanagment.system;
import javax.swing.*; // for JFrame class
import java.awt.*; // for color
import java.sql.*; //for ResultSet class which store the fetch data from database
import net.proteanit.sql.DbUtils; // for Jar file


public class FlightInfo extends JFrame  {
    public FlightInfo(){
        //background color for our frame
        getContentPane().setBackground(Color.WHITE); 
        //default layout null
        setLayout(null);
        
        //now i want to show the data in form of table
        // so i need to create the table
        JTable table = new JTable();
        //now when this class/ file run i want t show data from database 
        try{
            con Con = new con();
            //storing the data
            ResultSet rs = Con.s.executeQuery("select * from flight");  //anything data come from query we store in Result set(Used in Login file)
             // we use Jar file to display data in table format othrwise you have to use for loop,array etc (photo pc check it)    
            // we import jar file (yt)
            //there is 1 function jar file we have to use it
            table.setModel(DbUtils.resultSetToTableModel(rs)); // pass the ResultSet object in it
            //now above create the table but you have to put this table in (table) which we created
            //now table is created
            
        }catch(Exception ae){
            ae.printStackTrace();
        }
        //Adiing scrollbar in our table
        JScrollPane jsp = new JScrollPane(table); // scroll option presen tin this class and pass your table
        
        //set bounce the table
        jsp.setBounds(0, 0, 800, 500); //you can also write table but jsp gives you table +scrollbar
        add(jsp);
        
        //now we ste size for our frame
        setSize(800, 500);
        setLocation(400, 200);
        setVisible(true);
        
    }
    
    public static void main(String[] args){
        new FlightInfo();
        
    }
}
