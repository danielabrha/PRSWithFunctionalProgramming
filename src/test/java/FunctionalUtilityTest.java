import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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

    Role doctor, laboratorist, receptionist, systemAdmin;
    User user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12, user13, user14;
    Patient patient1, patient2, patient3, patient4, patient5, patient6, patient7, patient8, patient9, patient10;
Visit visit1,visit2,visit3,visit4,visit5,visit6,visit7,visit8,visit9,
        visit10,visit11,visit12,visit13,visit14,
        visit15,visit16,visit17,visit18,visit19,visit20,visit21,visit22,visit23,visit24,visit25;

    LabTestType saliva, urinalysis, blood, hemoglobin, liverPanel, endoscopy, std, dna, corona;
    LabResult positive, negative;
    Drug atorvastatin, levothyroxine, lisinopril, metformin, amlodipine, metoprolol, albuterol, omeprazole;
    DrugOrder drugOrder1, drugOrder2, drugOrder3, drugOrder4, drugOrder5, drugOrder6, drugOrder7, drugOrder8,
            drugOrder9, drugOrder10;
    Symptom chestPain, bloodStool, diarrhea, cough, dizziness, headache, vomiting, soreThroat, numbness, pelvicPain;

    @Before
    public void setUp() {

        // create role
        doctor = new Role("doctor");
        laboratorist = TestFactory.createRole("laboratorist");
        receptionist = TestFactory.createRole("receptionst");
        systemAdmin = TestFactory.createRole("system admin");


        // create user


        user1 = TestFactory.createUser("Daniel", "Fitsum",
                "Abrha", "Male", "dabrha@miu.edu", "123456789", "Chercher",
                LocalDateTime.of(1990, 02, 25, 1, 1, 1), "", ""
                , Arrays.asList(new Role[]{doctor, systemAdmin}));

        user2 = TestFactory.createUser("Kidst", "Tsegay",
                "Mezigebe", "Female", "ktsegay@miu.edu", "123456789", "Mekele",
                LocalDateTime.of(1990, 02, 25, 1, 1, 1), "", ""
                , Arrays.asList(new Role[]{receptionist}));

        user3 = TestFactory.createUser("Weldemicheal", "Hailu",
                "Birhanu", "Male", "whailu@miu.edu", "123456789", "Dengolate",
                LocalDateTime.of(1990, 02, 25, 1, 1, 1), "", ""
                , Arrays.asList(new Role[]{systemAdmin}));

        user3 = TestFactory.createUser("Abebe", "Abrha",
                "Tekle", "Male", "aabrha@miu.edu", "123456789", "Kuha",
                LocalDateTime.of(1990, 02, 25, 1, 1, 1), "", ""
                , Arrays.asList(new Role[]{laboratorist}));

        user4 = TestFactory.createUser("Gizachew", "Mekonen",
                "Birhane", "Male", "gmokenen@miu.edu", "123456789", "Tilili",
                LocalDateTime.of(1990, 02, 25, 1, 1, 1), "", ""
                , Arrays.asList(new Role[]{doctor, systemAdmin}));

        user5 = TestFactory.createUser("Mahder", "Fitsum",
                "Abrha", "Female", "mabrha@miu.edu", "123456789", "Chercher",
                LocalDateTime.of(1990, 02, 25, 1, 1, 1), "", ""
                , Arrays.asList(new Role[]{receptionist}));

        user6 = TestFactory.createUser("Yared", "Fitsum",
                "Abrha", "Male", "yabrha@miu.edu", "123456789", "Dergaejen",
                LocalDateTime.of(1990, 02, 25, 1, 1, 1), "", ""
                , Arrays.asList(new Role[]{doctor}));


        //region create Patient
        patient1 = TestFactory.createPatient("John", "Smith", "Williams", "male", "mich@miu.edu", "12345", "Miu",
                LocalDateTime.of(1989, 07, 29, 19, 30, 40), 1000);

        patient2 = TestFactory.createPatient("Anna", "park", "drake", "female", "annaf@miu.edu", "12345", "Miu",
                LocalDateTime.of(2010, 07, 17, 19, 30, 40), 1001);

        patient3 = TestFactory.createPatient("Joseph", "burce", "Lee", "male", "joseph@miu.edu", "12345", "Miu",
                LocalDateTime.of(1970, 05, 13, 19, 30, 40), 1002);

        patient4 = TestFactory.createPatient("Lia", "kizmak", "Berhanu", "female", "liaki@miu.edu", "01245", "Miu",
                LocalDateTime.of(1999, 01, 11, 19, 30, 40), 1003);

        patient5 = TestFactory.createPatient("Tibony", "mazuk", "kish", "female", "tibony@miu.edu", "123450", "Miu",
                LocalDateTime.of(1972, 12, 9, 19, 30, 40), 1004);

        patient6 = TestFactory.createPatient("Tekeste", "shabro", "bon", "male", "tekesteb@miu.edu", "01212345", "Miu",
                LocalDateTime.of(1960, 04, 25, 19, 30, 40), 1005);
        patient7 = TestFactory.createPatient("doni", "shamak", "tedi", "female", "donis@miu.edu", "9812345", "Miu",
                LocalDateTime.of(1990, 06, 20, 19, 30, 40), 1006);
        patient8 = TestFactory.createPatient("Mariamawi", "Demesko", "Abrha", "female", "mariad@miu.edu", "1230945",
                "Miu",
                LocalDateTime.of(1965, 07, 29, 19, 30, 40), 1007);

        patient9 = TestFactory.createPatient("Tesfay", "Bekru", "tsega", "male", "tesfb@miu.edu", "1234095", "Miu",
                LocalDateTime.of(2007, 10, 25, 19, 30, 40), 1008);
        patient10 = TestFactory.createPatient("Ajai", "Fantu", "siru", "male", "ajaf@miu.edu", "10802345",
                "Miu", LocalDateTime.of(2001, 07, 14, 19, 30, 40), 1009);

        //endregion
        //region create visit
        //region for patient one
        visit1=TestFactory.createVisit(LocalDateTime.of(2011,01,01,1,1,1),patient1,user2);
        visit2=TestFactory.createVisit(LocalDateTime.of(2011,05,02,1,1,1),patient1,user2);
        visit3=TestFactory.createVisit(LocalDateTime.of(2013,04,01,1,1,1),patient1,user2);
        visit4=TestFactory.createVisit(LocalDateTime.of(2014,03,01,1,1,1),patient1,user2);
        visit5=TestFactory.createVisit(LocalDateTime.of(2015,07,01,1,1,1),patient1,user2);
        //endregion
        //region for patient two
        visit6=TestFactory.createVisit(LocalDateTime.of(2011,01,01,1,1,1),patient2,user2);
        visit7=TestFactory.createVisit(LocalDateTime.of(2012,05,01,1,1,1),patient2,user2);
        visit8=TestFactory.createVisit(LocalDateTime.of(2013,04,01,1,1,1),patient2,user2);
        visit9=TestFactory.createVisit(LocalDateTime.of(2014,03,01,1,1,1),patient2,user2);
        visit10=TestFactory.createVisit(LocalDateTime.of(2015,07,01,1,1,1),patient2,user2);
        //endregion
        //region for patient three
        visit11=TestFactory.createVisit(LocalDateTime.of(2011,01,01,1,1,1),patient3,user2);
        visit12=TestFactory.createVisit(LocalDateTime.of(2012,05,01,1,1,1),patient3,user2);
        visit13=TestFactory.createVisit(LocalDateTime.of(2013,04,01,1,1,1),patient3,user2);
        visit14=TestFactory.createVisit(LocalDateTime.of(2014,03,01,1,1,1),patient3,user2);
        visit15=TestFactory.createVisit(LocalDateTime.of(2015,07,01,1,1,1),patient3,user2);
        //endregion
        //region for patient four
        visit16=TestFactory.createVisit(LocalDateTime.of(2011,01,01,1,1,1),patient4,user2);
        visit17=TestFactory.createVisit(LocalDateTime.of(2012,05,01,1,1,1),patient4,user2);
        visit18=TestFactory.createVisit(LocalDateTime.of(2013,04,01,1,1,1),patient4,user2);
        visit19=TestFactory.createVisit(LocalDateTime.of(2014,03,01,1,1,1),patient4,user2);
        visit20=TestFactory.createVisit(LocalDateTime.of(2015,07,01,1,1,1),patient4,user2);
        //endregion
        //region for patient five
        visit21=TestFactory.createVisit(LocalDateTime.of(2011,01,01,1,1,1),patient5,user2);
        visit22=TestFactory.createVisit(LocalDateTime.of(2012,05,01,1,1,1),patient5,user2);
        visit23=TestFactory.createVisit(LocalDateTime.of(2013,04,01,1,1,1),patient5,user2);
        visit24=TestFactory.createVisit(LocalDateTime.of(2014,03,01,1,1,1),patient5,user2);
        visit25=TestFactory.createVisit(LocalDateTime.of(2015,07,01,1,1,1),patient5,user2);
        //endregion
        //endregion


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