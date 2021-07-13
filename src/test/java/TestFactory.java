import java.util.ArrayList;
import java.util.List;

public abstract class TestFactory {


    static public LabTestType createLabTestType(String labTestName, String labTestCode, List<LabOrder> labOrderList,
                                                User user) {

        return new LabTestType(labTestName, labTestCode, labOrderList, user);
    }

    static public Drug createDrug(String drugName, String drugCode, List<DrugOrder> drugOrderList, User user) {
        return new Drug(drugName, drugCode, drugOrderList, user);
    }

    static public DrugOrder createDrugOrder(int amount, Drug drug, User user, Visit visit) {
        return new DrugOrder(amount, drug, user, visit);
    }

    static public LabResult createLabResult(String labResultName, LabOrder labOrder, User user) {
        return new LabResult(labResultName, labOrder, user);
    }

    static public LabOrder createLabOrder ( Visit visit, LabResult labResult, LabTestType labTestType, User user) {
        return new LabOrder(visit, labResult, labTestType, user);
    }

    static public Symptom createSymptom (String symptomName, Visit visit, User user) {
        return new Symptom(symptomName, visit, user);
    }
}

