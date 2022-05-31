package LLD.DesignPatterns.statePattern;

/*
This interface will have methods that will represent all possible actions that we
can perform using ATM.
 */
public interface ATMState {

    void insertCard();
    void ejectCard();
    void enterPin(int pinCode);
    void requestCash(int cashToWithdraw);

}
