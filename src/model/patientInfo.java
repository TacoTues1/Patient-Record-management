package model;

public class patientInfo {
    private String firstname;
    private String middlename;
    private String lastname;
    private int age;
    private String birthday;
    private String gender;
    private int pID;
    private String Choice;
    private String Status;
    

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    public String getChoice() {
        return Choice;
    }

    public void setChoice(String Choice) {
        this.Choice = Choice;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
  
    public void showDetails(){
        System.out.println("");
        System.out.println("\n                                            DETAILS");
        System.out.print("                                  Firstname: " + firstname);
        System.out.println("           Age: "+ age);
        System.out.print("                                  Middlename: " + middlename);
        System.out.println("             BirthDate: " + birthday);
        System.out.print("                                  Lastname: " + lastname);
        System.out.println("             Gender: " + gender);
        System.out.println("");
    }
}