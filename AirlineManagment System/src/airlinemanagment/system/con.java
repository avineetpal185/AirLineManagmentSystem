
package airlinemanagment.system;

import java.sql.*; // for connection and Statement


public class con {
    
     Connection c;
    Statement s;
    
    public con(){
           try{
            //1st step-registering the driver
            //by help of (forName->used to register the class present in CLASS)"iside inverted comman in driver name"
            //we download some files also store in Library
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2nd - put the inf of database you want to connect it  use Staement and Connection
            
       //below give the connectivity
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airplance","root","avineet4185aps");
        // statement is used to execute this connection with any statement
        s=c.createStatement();
       
             
       
       
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
