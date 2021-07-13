import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class TestFactory {


    static public LabTestType createLabTestType(String labTestName, String labTestCode,
                                                User user) {

        return new LabTestType(labTestName, labTestCode, user);
    }

    static public Drug createDrug(String drugName, String drugCode,  User user) {
        return new Drug(drugName, drugCode, user);
    }

    static public DrugOrder createDrugOrder(int amount, Drug drug, User user, Visit visit) {
        return new DrugOrder(amount, drug, user, visit);
    }

    static public LabResult createLabResult(String labResultName, LabOrder labOrder, User user) {
        return new LabResult(labResultName, labOrder, user);
    }

    static public LabOrder createLabOrder(Visit visit, LabTestType labTestType, User user) {
        return new LabOrder(visit, labTestType, user);
    }

    static public Symptom createSymptom(String symptomName, Visit visit, User user) {
        return new Symptom(symptomName, visit, user);
    }

        static public Role createRole (String name){
            return new Role(name);
        }

        static public User createUser (String fName, String lName, String mName, String gender,
                String email, String phoneNumber,
                String address, LocalDateTime dateOfBirth,
                String userName, String password, List < Role > roles){
            return new User(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth, userName, password
                    , roles);


        }

        public static Patient createPatient (String fName, String lName, String mName, String gender, String email,
                String phoneNumber, String address, LocalDateTime dateOfBirth,
        int cardRecordNumber){
            return new Patient(fName, lName, mName, gender, email,
                    phoneNumber, address, dateOfBirth, cardRecordNumber);
        }

        public static Visit createVisit (LocalDateTime visitDate, Patient patient, User user){
            return new Visit(visitDate, patient, user);
        }

    }


