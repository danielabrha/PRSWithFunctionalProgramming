import java.util.List;

public class LabTestType {

    private String labTestName;
    private String labTestCode;
    private List<LabOrder> labOrderList;
    private User user;

    public LabTestType(String labTestName, String labTestCode, List<LabOrder> labOrderList, User user) {
        this.labTestName = labTestName;
        this.labTestCode = labTestCode;
        this.labOrderList = labOrderList;
        this.user = user;
    }

    public LabTestType(String labTestName, String labTestCode) {
        this.labTestName = labTestName;
        this.labTestCode = labTestCode;
    }

    public LabTestType() {
    }

    public String getLabTestName() {
        return labTestName;
    }

    public void setLabTestName(String labTestName) {
        this.labTestName = labTestName;
    }

    public String getLabTestCode() {
        return labTestCode;
    }

    public void setLabTestCode(String labTestCode) {
        this.labTestCode = labTestCode;
    }

    public List<LabOrder> getLabOrderList() {
        return labOrderList;
    }

    public void setLabOrderList(List<LabOrder> labOrderList) {
        this.labOrderList = labOrderList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
