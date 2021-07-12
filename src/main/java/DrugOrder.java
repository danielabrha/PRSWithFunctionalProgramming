public class DrugOrder {

    private int amount;
    private Drug drug;
    private User user;
    private Visit visit;

    public DrugOrder(int amount, Drug drug, User user, Visit visit) {
        this.amount = amount;
        this.drug = drug;
        this.user = user;
        this.visit = visit;
    }


    public DrugOrder(int amount) {
        this.amount = amount;
    }

    public DrugOrder() {
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

