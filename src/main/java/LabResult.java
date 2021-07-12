public class LabResult {

    private String labResultName;
    private LabOrder labOrder;
    private User user;

    public LabResult(String labResultName, LabOrder labOrder, User user) {
        this.labResultName = labResultName;
        this.labOrder = labOrder;
        this.user = user;
    }

    public LabResult(String labResultName) {
        this.labResultName = labResultName;
    }

    public LabResult() {
    }

    public String getLabResultName() {
        return labResultName;
    }

    public void setLabResultName(String labResultName) {
        this.labResultName = labResultName;
    }

    public LabOrder getLabOrder() {
        return labOrder;
    }

    public void setLabOrder(LabOrder labOrder) {
        this.labOrder = labOrder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
