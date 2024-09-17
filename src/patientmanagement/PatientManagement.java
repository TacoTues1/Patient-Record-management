package patientmanagement;


import model.patientInfo;
import java.util.Scanner;
import Interface.Action;
import Interface.ActionImplementation;
import java.util.ArrayList;

public class PatientManagement {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
        System.out.println("                                  ==========================================================================================");
        System.out.println("                                                                WELCOME to PATIENT RECORD MANAGEMENT");
        System.out.println("                                  ==========================================================================================");
        System.out.print("                                  1.Add (Check up)                                                ");
        System.out.println("3.Delete Patient Record");
        System.out.print("                                  2.Update (DisCharge, Re-Check Up,Edit Patient Record)           ");
        System.out.println("4. Delete Specified Record");
        System.out.print("                                  5. View All Records                                             ");
        System.out.println("6.View Specified Record");
        System.out.print("                                  7. Delete all records                                         ");
        System.out.print("\n                                                   Enter: ");
        switch(scan.nextLine()){
            case "1":
                checkUp();
                break;
            case "2":
                System.out.println("                                                   1.Check out");
                System.out.println("                                                   2.Re-Check up");
                 System.out.println("                                                   3.Edit Patient Record");
                System.out.print("                                                   Enter: ");
                switch(scan.nextLine()){
                    case "1":
                        checkout();
                        break;             
                    case "2":
                        reCheckUp();
                        break;
                    case "3":
                      editRecord();
                        break;
                }
                break;
            case "4":
                  deleteRecord();
                break;
            case "5":
                viewAll();
                break;
            case "6":
                viewOne();
                break;
            case "7":
                deleteAll();
                break;
        }
        }
    }
    public static void deleteAll(){
        patientInfo pinfo = new patientInfo();
    Action act = new ActionImplementation();
      
         if(act.deleteAll(pinfo) == true){
        System.out.println("                                  Successfully Deleted");
    }
    else {
        System.out.println("                                  Failed to Delete try again later");
    }
    }
    public static void editRecord(){
        Scanner scan = new Scanner (System.in);
    patientInfo pInfo = new patientInfo();
        System.out.print("                                  Enter ID: ");
        pInfo.setpID(scan.nextInt());
        scan.nextLine();
        System.out.print("                                  Enter Firstname: ");
        pInfo.setFirstname(scan.nextLine().toLowerCase());
         System.out.print("                                  Enter middlename: ");
        pInfo.setMiddlename(scan.nextLine().toLowerCase());
         System.out.print("                                  Enter Lastname: ");
        pInfo.setLastname(scan.nextLine().toLowerCase());
         System.out.print("                                  Enter Age: ");
        pInfo.setAge(scan.nextInt());
        
        scan.nextLine();
         System.out.print("                                  Enter BirthDay: ");
        pInfo.setBirthday(scan.nextLine().toLowerCase());
         System.out.print("                                  Enter Gender: ");
        pInfo.setGender(scan.nextLine().toLowerCase());
          
        Action act = new ActionImplementation();
        
        if(act.editRecord(pInfo) == true){
            System.out.println("                                  Edit Succesfully");
        }
        else {
            System.out.println("                                  Failed to Edit try again");
        }
        
    
  
    }
    public static void checkUp(){
        Scanner scan = new Scanner(System.in);
        patientInfo pInfo = new patientInfo();
        System.out.print("                                  Enter Firstname: ");
        pInfo.setFirstname(scan.nextLine().toLowerCase());
         System.out.print("                                  Enter middlename: ");
        pInfo.setMiddlename(scan.nextLine().toLowerCase());
         System.out.print("                                  Enter Lastname: ");
        pInfo.setLastname(scan.nextLine().toLowerCase());
         System.out.print("                                  Enter Age: ");
        pInfo.setAge(scan.nextInt());
        
        scan.nextLine();
         System.out.print("                                  Enter BirthDay: ");
        pInfo.setBirthday(scan.nextLine().toLowerCase());
         System.out.print("                                  Enter Gender: ");
        pInfo.setGender(scan.nextLine().toLowerCase());
    
        Action act = new ActionImplementation();
        
    if(act.checkIn(pInfo) == true){
        pInfo.showDetails();
                System.out.println("                                  Recorded Succesfully");
    }
    else {
        System.out.println("                                  Failed to Record");
    }
    
    }
    
    public static void reCheckUp(){
    Scanner scan = new Scanner(System.in);
        patientInfo pinfo = new patientInfo();
       
        System.out.print("                                  Enter ID: ");
        pinfo.setpID(scan.nextInt());
     
        Action act = new ActionImplementation();
             
    if(act.disCharge(pinfo) == true){
        System.out.println("                                  Re-Check up Succesfully");
    }
    else {
        System.out.println("                                  Failed to Re-Check up try again later");
    }
    }
    
    public static void checkout(){
        Scanner scan = new Scanner(System.in);
        patientInfo pinfo = new patientInfo();
       
        System.out.print("                                  Enter ID: ");
        pinfo.setpID(scan.nextInt());
     
        Action act = new ActionImplementation();
             
    if(act.disCharge(pinfo) == true){
        System.out.println("                                  Check Out Succesfully");
    }
    else {
        System.out.println("                                  Failed to Check out try again Later");
    }
        
    }
  public static void viewAll(){
    patientInfo pinfo = new patientInfo();
    Action act = new ActionImplementation();
    
    ArrayList<String[]> records = act.viewRecord();
    
    if(records.isEmpty()){
        System.out.println("Failed to Show record try again later");
    }
    else {
        System.out.println("===========================================================================================");
        System.out.printf("%-8s %-11s %-11s %-11s %-10s %-21s %-6s %-11s%n",
                "Patient ID",
                "Firstname",
                "Middlename",
                "Lastname",
                "Age",
                "BirthDate",
                "Gender",
                "Status"
        );
        for(String[] record : records) {
            System.out.printf("%-8s %-11s %-11s %-11s %-10s %-21s %-6s %-11s%n",
                    record[0],
                    record[1],
                    record[2],
                    record[3],
                    record[4],
                    record[5],
                    record[6],
                    record[7]
            );
        }
    }
}

    
    public static void viewOne(){
        Scanner scan = new Scanner(System.in);
        patientInfo pinfo = new patientInfo();
        Action act = new ActionImplementation();

        System.out.print("                                  Enter ID or firstname: ");
        String IDorNAME = scan.nextLine();

       
        try { 
            int id = Integer.parseInt(IDorNAME);
            pinfo.setpID(id);
        } catch (NumberFormatException e) {
           
            pinfo.setFirstname(IDorNAME);
        }

        if (act.viewOneRecord(pinfo) == false) {
            System.out.println("                                  Failed to Show record try again later");
        }
        else{
        pinfo.showDetails();
        }
    }
    
    public static void deleteRecord(){
                patientInfo pinfo = new patientInfo();
    Scanner scan = new Scanner(System.in);
    Action act = new ActionImplementation();
    act.viewRecord();
        System.out.print("                                  Enter ID to Delete: `" );
        pinfo.setpID(scan.nextInt());
        
        
      
    }
}