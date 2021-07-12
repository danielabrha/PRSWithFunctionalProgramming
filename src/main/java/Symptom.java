public class Symptom {


    private String symptomName;
    private Visit visit;
    private User user;

    public Symptom(String symptomName, Visit visit, User user) {
        this.symptomName = symptomName;
        this.visit = visit;
        this.user = user;
    }
    public Symptom(String symptomName) {
        this.symptomName = symptomName;
    }
    public Symptom() {
    }

    public String getSymptomName() {
        return symptomName;
    }

    public void setSymptomName(String symptomName) {
        this.symptomName = symptomName;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
