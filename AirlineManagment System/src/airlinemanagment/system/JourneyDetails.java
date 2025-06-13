package airlinemanagment.system;
    
import javax.swing.*; // for JFrame class
import java.awt.*; // for color
import java.sql.*; //for ResultSet class which store the fetch data from database
import net.proteanit.sql.DbUtils; // for Jar file
import java.awt.event.*;


public class JourneyDetails extends JFrame implements ActionListener {
    JTable table;
    JTextField pnr;
    JButton show;
    public JourneyDetails(){
        //background color for our frame
        getContentPane().setBackground(Color.WHITE); 
        //default layout null
        setLayout(null);
        
        JLabel lblpnr = new JLabel ("PNR Details");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpnr.setBounds(50, 50, 100, 25);  //Simple text
        add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(160, 50, 120, 25); //Textfield
        add(pnr);
        
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);  //iT is ShowDetails Button
        show.setForeground(Color.WHITE);
        show.setBounds(290, 50, 120, 25);
        show.addActionListener(this);
        add(show);
        
       table = new JTable();
       
       //Below Make the Rectangle field which diplay our data
       
        //Adiing scrollbar in our table
        JScrollPane jsp = new JScrollPane(table); // scroll option presen tin this class and pass your table
        //set bounce the table
        jsp.setBounds(0, 100, 800, 150); //you can also write table but jsp gives you table +scrollbar
        jsp.setBackground(Color.WHITE);
        add(jsp);
        
        //now we ste size for our frame
        setSize(800, 500);
        setLocation(400, 150);
        setVisible(true);
        
    }
    
    //overriding ActionListener function
    public void actionPerformed(ActionEvent ae){
         try{
            con Con = new con();
            //storing the data
            ResultSet rs = Con.s.executeQuery("select * from reservation where PNR = '"+pnr.getText()+"'");  //anything data come from query we store in Result set(Used in Login file)
            
            if(!rs.isBeforeFirst()){
                //above line->if value is not present
                
                //if information no found
                JOptionPane.showMessageDialog(null, "No Information Found");
                return;
            }
            //there is 1 function jar file we have to use it
            table.setModel(DbUtils.resultSetToTableModel(rs)); // pass the ResultSet object in it
            //now above create the table but you have to put this table in (table) which we created
            //now table is created
            
        } catch(Exception e){
            e.printStackTrace();
        }
    } 
    
    public static void main(String[] args){
        new JourneyDetails();
        
    }
}
