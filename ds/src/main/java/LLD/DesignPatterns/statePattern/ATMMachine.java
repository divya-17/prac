package LLD.DesignPatterns.statePattern;

public class ATMMachine {

    ATMState hasCard;
    ATMState noCard;
    ATMState hasCorrectPin;
    ATMState atmOutOfMoney;

    ATMState currentATMState;

    int cashInMachine;
    boolean correctPinEntered;

    public ATMMachine(){
        hasCard = new HasCardATMState(this);
        noCard = new NoCardATMState(this);
        hasCorrectPin = new HasCorrectPinATMState(this);
        atmOutOfMoney = new ATMOutOfMoneyState(this);

        currentATMState = noCard;
        cashInMachine = 2000;
        correctPinEntered = false;
    }


    public void setCashInMachine(int newCash){
        cashInMachine = newCash;
    }
    public void setATMState(ATMState currState){
        currentATMState = currState;
    }

    public void insertCard(){
        currentATMState.insertCard();
    }

    public void ejectCard(){
        currentATMState.ejectCard();
    }

    public void enterPin(int pinCode){
        currentATMState.enterPin(pinCode);
    }

    public void requestCash(int cashToWithdraw){
        currentATMState.requestCash(cashToWithdraw);
    }


    public ATMState getHasCardState() { return hasCard; }
    public ATMState getNoCard() { return noCard; }
    public ATMState getHasCorrectPin() { return hasCorrectPin;}
    public ATMState getOutOfMoneyState() { return atmOutOfMoney; }
}
