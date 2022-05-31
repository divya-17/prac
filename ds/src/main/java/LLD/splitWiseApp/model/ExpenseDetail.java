package LLD.splitWiseApp.model;

import java.util.List;

public class ExpenseDetail {

    List<User> payer;
    User recepient;
    Long amount;
    DistributionType distributionType;
    List<Long> distributionAmounts;


    public ExpenseDetail(List<User> payer, User recepient, Long amount, DistributionType distributionType, List<Long> distributionAmounts) {
        this.payer = payer;
        this.recepient = recepient;
        this.amount = amount;
        this.distributionType = distributionType;
        this.distributionAmounts = distributionAmounts;

    }

    public List<User> getPayer() {
        return payer;
    }

    public void setPayer(List<User> payer) {
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

    public DistributionType getDistributionType() {
        return distributionType;
    }

    public void setDistributionType(DistributionType distributionType) {
        this.distributionType = distributionType;
    }

    public List<Long> getDistributionAmounts() {
        return distributionAmounts;
    }

    public void setDistributionAmounts(List<Long> distributionAmounts) {
        this.distributionAmounts = distributionAmounts;
    }

    @Override
    public String toString() {
        return "ExpenseDetail{" +
                "payer=" + payer +
                ", recepient=" + recepient +
                ", amount=" + amount +
                ", distributionType=" + distributionType +
                ", distributionAmounts=" + distributionAmounts +
                '}';
    }
}
