import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {


    private int cardRecordNumber;

    private List<Visit> visitList;

    public Patient(String fName, String lName, String mName, String gender, String email,
                   String phoneNumber, String address, LocalDateTime dateOfBirth,
                   int cardRecordNumber, List<Visit> visitList) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.cardRecordNumber = cardRecordNumber;
        this.visitList = visitList;
    }
    public Patient(String fName, String lName, String mName, String gender, String email,
                   String phoneNumber, String address, LocalDateTime dateOfBirth,
                   int cardRecordNumber) {
        super(fName, lName, mName, gender, email, phoneNumber, address, dateOfBirth);
        this.cardRecordNumber = cardRecordNumber;
        this.visitList = new ArrayList<>();
    }
    public Patient(int cardRecordNumber, List<Visit> visitList) {
        this.cardRecordNumber = cardRecordNumber;
        this.visitList = visitList;
    }
    public Patient(int cardRecordNumber) {
        this.cardRecordNumber = cardRecordNumber;
        this.visitList = new ArrayList<>();
    }

    public int getCardRecordNumber() {
        return cardRecordNumber;
    }

    public void setCardRecordNumber(int cardRecordNumber) {
        this.cardRecordNumber = cardRecordNumber;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }
}

