import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestFactory {
    static public Role createRole(String name) {
        return new Role(name);
    }

    static public User createUser(String fName, String lName, String mName, String gender,
                                  String email, String phoneNumber,
                                  String address, LocalDateTime dateOfBirth,
                                  String userName, String password, List<Role> roles) {
        return new User(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth, userName, password, roles);


    }

    public static Patient createPatient(String fName, String lName, String mName, String gender, String email,
                                        String phoneNumber, String address, LocalDateTime dateOfBirth,
                                        int cardRecordNumber) {
        return new Patient(fName, lName, mName, gender, email,
                phoneNumber, address, dateOfBirth, cardRecordNumber);
    }

    public static Visit createVisit(LocalDateTime visitDate, Patient patient, User user) {
        return new Visit(visitDate, patient, user);
    }

}
