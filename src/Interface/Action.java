package Interface;

import java.util.ArrayList;
import model.patientInfo;

public interface Action {
    public boolean checkIn(patientInfo pInfo);
    public boolean disCharge(patientInfo pInfo);
    public ArrayList<String[]> viewRecord();
    public boolean viewOneRecord(patientInfo pInfo);
    public boolean editRecord(patientInfo pInfo);
    public boolean delete(patientInfo pinfo);
    public boolean reCheckUp(patientInfo pInfo);
    public boolean deleteAll(patientInfo pinfo);
}