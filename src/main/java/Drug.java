import java.util.ArrayList;
import java.util.List;

public class Drug {

    private String drugName;
    private String drugCode;
    private List<DrugOrder> drugOrderList;
    private User user;

    public Drug(String drugName, String drugCode, List<DrugOrder> drugOrderList, User user) {
        this.drugName = drugName;
        this.drugCode = drugCode;
        this.drugOrderList = drugOrderList;
        this.user = user;
    }
    public Drug(String drugName, String drugCode) {
        this.drugName = drugName;
        this.drugCode = drugCode;
    }
    public Drug(String drugName, String drugCode,User user) {
        this.drugName = drugName;
        this.drugCode = drugCode;
        this.user=user;
        this.drugOrderList=new ArrayList<>();
    }

    public Drug() {
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
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
