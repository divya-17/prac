package LLD.DesignPatterns.statePattern;

public class HasCorrectPinATMState implements ATMState {

    ATMMachine atmMachine;

    public HasCorrectPinATMState(ATMMachine atmMachine){
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("Card already entered. Can't enter it twice.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected");
        atmMachine.setATMState(atmMachine.getNoCard());
    }

    @Override
    public void enterPin(int pinCode) {
        System.out.println("Pin already entered");
    }

    @Override
    public void requestCash(int cashToWithdraw) {

        if(cashToWithdraw > atmMachine.cashInMachine){
            System.out.println("Don't have sufficient balance. Card ejected");
            atmMachine.setATMState(atmMachine.getNoCard());
        }
        else{
            atmMachine.setCashInMachine(atmMachine.cashInMachine - cashToWithdraw);
            System.out.println("Cash withdrawn from ATM machine is "+cashToWithdraw);
            atmMachine.setATMState(atmMachine.getNoCard());

            if(atmMachine.cashInMachine <= 0){

                atmMachine.setATMState(atmMachine.getOutOfMoneyState());
            }
        }
    }
}
