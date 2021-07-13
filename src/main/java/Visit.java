import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Visit {

    private LocalDateTime visitDate;
    private Patient patient;
    private List<Symptom> symptomList;
    private List<LabOrder> labOrderList;
    private List<DrugOrder> drugOrderList;
    private User user;

    public Visit(LocalDateTime visitDate, Patient patient,
                 List<Symptom> symptomList, List<LabOrder> labOrderList,
                 List<DrugOrder> drugOrderList, User user) {
        this.visitDate = visitDate;
        this.patient = patient;
        this.symptomList = symptomList;
        this.labOrderList = labOrderList;
        this.drugOrderList = drugOrderList;
        this.user = user;
    }

    public Visit(LocalDateTime visitDate,Patient patient,User user) {
        this.visitDate = visitDate;
        this.patient=patient;
        this.user=user;
    }


    public Visit() {
    }

    public LocalDateTime getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDateTime visitDate) {
        this.visitDate = visitDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Symptom> getSymptomList() {
        return symptomList;
    }

    public void setSymptomList(List<Symptom> symptomList) {
        this.symptomList = symptomList;
    }

    public List<LabOrder> getLabOrderList() {
        return labOrderList;
    }

    public void setLabOrderList(List<LabOrder> labOrderList) {
        this.labOrderList = labOrderList;
    }

    public List<DrugOrder> getDrugOrderList() {
        return drugOrderList;
    }

    public void setDrugOrderList(List<DrugOrder> drugOrderList) {
        this.drugOrderList = drugOrderList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
