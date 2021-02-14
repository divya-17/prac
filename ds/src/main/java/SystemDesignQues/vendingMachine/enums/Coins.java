package SystemDesignQues.vendingMachine.enums;

public enum Coins {

    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    private int denomination;

    public int getDenomination() {
        return denomination;
    }

    public void setDenomination(int denomination) {
        this.denomination = denomination;
    }

    Coins(int denomination) {
        this.denomination = denomination;
    }
}
