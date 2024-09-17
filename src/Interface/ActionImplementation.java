package Interface;

import model.patientInfo;
import DatabaseCon.databaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class ActionImplementation implements Action{

    @Override
    public boolean checkIn(patientInfo pinfo) {
        boolean result = false;

       try{
       Connection connection = databaseConnection.DBconnection();
       String query = "INSERT INTO p_info VALUES(null,?,?,?,?,?,?,?,null)";
       PreparedStatement prepared = connection.prepareStatement(query);
       prepared.setString(1, pinfo.getFirstname());
       prepared.setString(2, pinfo.getMiddlename());
       prepared.setString(3, pinfo.getLastname());
       prepared.setInt(4, pinfo.getAge());
       prepared.setString(5, pinfo.getBirthday());
       prepared.setString(6, pinfo.getGender());
       prepared.setString(7, "YES");
     if(prepared.executeUpdate() == 1){
         result = true;
     }
       }
       catch(Exception e){
           System.out.println(e);
       }
       return result;
    }
    

    @Override
    public boolean disCharge(patientInfo pinfo) {
         boolean result = false;
       try{
       Connection connection = databaseConnection.DBconnection();
       String query = "UPDATE p_info SET Status = ? WHERE Patient_ID = ?";
       PreparedStatement prepared = connection.prepareStatement(query);

       prepared.setString(1, "NO");
       prepared.setInt(2, pinfo.getpID());
     if(prepared.executeUpdate() == 1){
         result = true;
     }
       }
       catch(Exception e){
           System.out.println(e);
       }
       return result;
    }

    @Override
  public ArrayList<String[]> viewRecord() {
    ArrayList<String[]> records = new ArrayList<>();
    try {
        Connection connection = databaseConnection.DBconnection();
        String query = "SELECT * FROM p_info";
        PreparedStatement prepared = connection.prepareStatement(query);
        ResultSet resultSet = prepared.executeQuery(); 

        while(resultSet.next()) {
            String[] record = {
                String.valueOf(resultSet.getInt("Patient_ID")),
                resultSet.getString("firstname"),
                resultSet.getString("middlename"),
                resultSet.getString("lastname"),
                String.valueOf(resultSet.getInt("Age")),
                resultSet.getString("BirthDate"),
                resultSet.getString("Gender"),
                resultSet.getString("Status")
            };
            records.add(record);
        }
   
        resultSet.close();
        prepared.close();
        connection.close();

    } catch (Exception e) {
        e.printStackTrace(); // print the stack trace for debugging
    }
    return records;
}



    @Override
    public boolean editRecord(patientInfo pinfo) {
        Scanner scan = new Scanner(System.in);
       boolean result = false;

       try{
           Connection connection = databaseConnection.DBconnection();
       String query = "UPDATE p_info SET firstname = ?,middlename = ?, lastname = ?, Age = ?, BirthDate = ?, Gender = ? WHERE Patient_ID = ?";
       PreparedStatement prepared = connection.prepareStatement(query);
       prepared.setString(1, pinfo.getFirstname());
       prepared.setString(2, pinfo.getMiddlename());
       prepared.setString(3, pinfo.getLastname());
       prepared.setInt(4, pinfo.getAge());
       prepared.setString(5, pinfo.getBirthday());
       prepared.setString(6, pinfo.getGender());
       prepared.setInt(7, pinfo.getpID());
         if(prepared.executeUpdate() == 1){
         result = true;
     }
       }
       catch(Exception e){
           System.out.println(e);
       }
       return result;
        
    }

    @Override
    public boolean delete(patientInfo pinfo) {
        boolean result = false;
try {
            Connection connection = databaseConnection.DBconnection();
            String query = "SELECT * FROM p_info LIMIT 10";
            PreparedStatement prepared = connection.prepareStatement(query);
            ResultSet resultSet = prepared.executeQuery(); 
            
             System.out.println("                                  ===========================================================================================");
        System.out.printf("                                  %-8s %-11s %-11s %-11s %-10s %-21s %-6s %-11s %n",
                "Patient ID",
                "Firstname",
                "Middlename",
                "Lastname",
                "Age",
                "BirthDate",
                "Gender",
                "Status"
        );
        while(resultSet.next()) {
            System.out.printf("                                  %-8d %-11s %-11s %-11s %-10d %-21s %-6s %-11s %n",
                    resultSet.getInt("Patient_ID"),
                    resultSet.getString("firstname"),
                    resultSet.getString("middlename"),
                    resultSet.getString("lastname"),
                    resultSet.getInt("Age"),
                    resultSet.getString("BirthDate"),
                    resultSet.getString("Gender"),
                    resultSet.getString("Status"));
        }
       
            resultSet.close();
            prepared.close();
            connection.close();

        
        } catch (Exception e) {
            System.out.println(e);
          
        }
        try{
       Connection connection = databaseConnection.DBconnection();
       String query = "DELETE FROM p_info WHERE Patient_ID = ?";
       PreparedStatement prepared = connection.prepareStatement(query);
       prepared.setInt(1, pinfo.getpID());
       if(prepared.executeUpdate() == 1){
         result = true;
     }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
       
       return result;
    }

    @Override
  public boolean viewOneRecord(patientInfo pinfo) {
    try {
        Connection connection = databaseConnection.DBconnection();
        String query = "SELECT * FROM p_info WHERE Patient_ID = ?";
        PreparedStatement prepared = connection.prepareStatement(query);
        prepared.setInt(1, pinfo.getpID());
        ResultSet resultSet = prepared.executeQuery();

        if (resultSet.next()) {
            pinfo.setpID(resultSet.getInt("Patient_ID"));
            pinfo.setFirstname(resultSet.getString("firstname"));
            pinfo.setMiddlename(resultSet.getString("middlename"));
            pinfo.setLastname(resultSet.getString("lastname"));
            pinfo.setAge(resultSet.getInt("Age"));
            pinfo.setGender(resultSet.getString("Gender"));
            pinfo.setBirthday(resultSet.getString("BirthDate"));
            pinfo.setStatus(resultSet.getString("Status"));
            resultSet.close();
            prepared.close();
            connection.close();

            return true; // Record found
        } else {
            resultSet.close();
            prepared.close();
            connection.close();
            
            return false; // Record not found
        }
    } catch (Exception e) {
        System.out.println(e);
        return false;
    }
}


    @Override
    public boolean reCheckUp(patientInfo pInfo) {
         boolean result = false;
       try{
       Connection connection = databaseConnection.DBconnection();
       String query = "UPDATE p_info SET Status = ? WHERE Patient_ID = ?";
       PreparedStatement prepared = connection.prepareStatement(query);

       prepared.setString(1, "YES");
       prepared.setInt(2, pInfo.getpID());
     if(prepared.executeUpdate() == 1){
         result = true;
     }
       }
       catch(Exception e){
           System.out.println(e);
       }
       return result;
    }

    @Override
    public boolean deleteAll(patientInfo info) {
        boolean result = false;
       try{
       Connection connection = databaseConnection.DBconnection();
       String query = "DELETE FROM p_info";
       PreparedStatement prepared = connection.prepareStatement(query);
      
       if(prepared.executeUpdate() == 1){
         result = true;
     }
        }catch(Exception e){
            System.out.println(e);
        }
  
       return result;    
    }
    
}