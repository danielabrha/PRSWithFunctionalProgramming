import java.util.List;

public class Patient extends Person {


    private int cardRecordNumber;

    private List<Visit> visitList;

    public Patient(int cardRecordNumber, List<Visit> visitList) {
        this.cardRecordNumber = cardRecordNumber;
        this.visitList = visitList;
    }

    public Patient(int cardRecordNumber) {
        this.cardRecordNumber = cardRecordNumber;
    }

    public Patient() {
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

