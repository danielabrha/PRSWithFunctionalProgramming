import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FunctionalUtilityTest {

    List<Patient> patientList;
    List<User> userList;
    List<Role> roleList;
    List<Visit> visitList;
    List<LabTestType> labTestTypeList;
    List<LabOrder> labOrderList;
    List<LabResult> labResultList;
    List<Symptom> symptomList;
    List<Drug> drugList;

    Patient patient1, patient2, patient3, patient4, patient5, patient6, patient7, patient8, patient9, patient10;
    Role doctor, laboratorist, receptionist, systemAdmin;

    LabTestType saliva, urinalysis, blood, hemoglobin, liverPanel, endoscopy, std, dna, corona;
    LabResult positive, negative;
    Drug atorvastatin, levothyroxine, lisinopril, metformin, amlodipine, metoprolol, albuterol, omeprazole;
    DrugOrder drugOrder1, drugOrder2, drugOrder3, drugOrder4, drugOrder5, drugOrder6, drugOrder7, drugOrder8,
            drugOrder9, drugOrder10;
    Symptom chestPain, bloodStool, diarrhea, cough, dizziness, headache, vomiting, soreThroat, numbness, pelvicPain;

    @Before
    public void setUp() {

        //create Patient
        patient1 = TestFactory.createPatient("Weldmicheal", "Hailu", "Berhanu", "male", "mich@miu.edu", "12345", "Miu", LocalDateTime.of(2015, 07, 29, 19,30, 40), 1000);


        //create labTestType
        saliva = TestFactory.createLabTestType("saliva", "sal123", use1);
        urinalysis = TestFactory.createLabTestType("urinalysis", "u123", user1);
        blood = TestFactory.createLabTestType("blood", "bld123", user1);
        hemoglobin = TestFactory.createLabTestType("hemoglobin", "hemg123", user1);
        liverPanel = TestFactory.createLabTestType("liverPanel", "liv123", user1);
        endoscopy = TestFactory.createLabTestType("endoscopy", "end123", user1);
        std = TestFactory.createLabTestType("std", "std123", user1);
        dna = TestFactory.createLabTestType("dna", "dna123", user1);
        corona = TestFactory.createLabTestType("corona", "cor123", user1);

        // create LabResult
        positive = TestFactory.createLabResult("positive", lab01, user1);
        negative = TestFactory.createLabResult("negative", lab02, user2);

        //create Drug
        atorvastatin = TestFactory.createDrug("atorvastatin", "atorABC", user);
        levothyroxine = TestFactory.createDrug("levothyroxine", "levoABC", user);
        lisinopril = TestFactory.createDrug("lisinopril", "lisiABC", user);
        metformin = TestFactory.createDrug("metformin", "metfABC", user);
        amlodipine = TestFactory.createDrug("amlodipine", "amlodABC", user);
        metoprolol = TestFactory.createDrug("metoprolol", "metoABC", user);
        albuterol = TestFactory.createDrug("albuterol", "albtABC", user);
        omeprazole = TestFactory.createDrug("omeprazole", "omepABC", user);

        //create Symptom

        chestPain = TestFactory.createSymptom("chestPain", visit1, user);
        bloodStool = TestFactory.createSymptom("bloodStool", visit1, user);
        diarrhea = TestFactory.createSymptom("diarrhea", visit1, user);
        cough = TestFactory.createSymptom("cough", visit1, user);
        dizziness = TestFactory.createSymptom("dizziness", visit1, user);
        headache = TestFactory.createSymptom("headache", visit1, user);
        vomiting = TestFactory.createSymptom("vomiting", visit1, user);
        soreThroat = TestFactory.createSymptom("soreThroat", visit1, user);
        numbness = TestFactory.createSymptom("numbness", visit1, user);
        pelvicPain = TestFactory.createSymptom("pelvicPain", visit1, user);


        // create DrugOrder

        drugOrder1 = TestFactory.createDrugOrder(10, atorvastatin, user, visit);


    }

    @Test
    public void numberOfPatientsWithResultXTest() {

    }

}