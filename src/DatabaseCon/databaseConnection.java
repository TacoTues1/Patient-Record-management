package DatabaseCon;

import java.sql.Connection;
import java.sql.DriverManager;

public class databaseConnection {
    
    static Connection connection;
    
    public static Connection DBconnection(){
    try{
    Class.forName("com.mysql.jdbc.Driver");
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "patientinfo","root","");
    }catch(Exception e){
        System.out.println(e);
    }
    
   return connection;
    }
}