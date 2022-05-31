package LLD.splitWiseApp.model;


public class ExpenseProfile {

    User payer;
    User recepient;
    Long amount;

    public ExpenseProfile(User payer, User recepient, Long amount) {
        this.payer = payer;
        this.recepient = recepient;
        this.amount = amount;
    }

    public ExpenseProfile(){
        this.payer = null;
        this.recepient = null;
        this.amount = 0L;
    }
    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public User getRecepient() {
        return recepient;
    }

    public void setRecepient(User recepient) {
        this.recepient = recepient;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ExpenseProfile{" +
                "payer=" + payer+
                ", recepient=" + recepient +
                ", amount=" + amount +
                '}';
    }
}
