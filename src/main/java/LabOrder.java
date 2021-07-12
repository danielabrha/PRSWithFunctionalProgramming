public class LabOrder {

    private Visit visit;
    private LabResult labResult;
    private LabTestType labTestType;
    private User user;

    public LabOrder( Visit visit, LabResult labResult, LabTestType labTestType, User user) {
        this.visit = visit;
        this.labResult = labResult;
        this.labTestType = labTestType;
        this.user = user;
    }

    public LabOrder() {
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public LabResult getLabResult() {
        return labResult;
    }

    public void setLabResult(LabResult labResult) {
        this.labResult = labResult;
    }

    public LabTestType getLabTestType() {
        return labTestType;
    }

    public void setLabTestType(LabTestType labTestType) {
        this.labTestType = labTestType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
