package LLD.DesignPatterns.statePattern;

public class HasCardATMState implements ATMState {

    ATMMachine atmMachine;

    public HasCardATMState(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("You can't enter more than one card");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected !");
        atmMachine.setATMState(atmMachine.getNoCard());
    }

    @Override
    public void enterPin(int pinCode) {

        if(pinCode == 1234){
            System.out.println("Pin entered correctly ");
            atmMachine.setATMState(atmMachine.hasCorrectPin);
            atmMachine.correctPinEntered = true;
        }
        else {
            System.out.println("Wrong pin entered. Ejecting the card !");
            atmMachine.setATMState(atmMachine.getNoCard());
        }
    }

    @Override
    public void requestCash(int cashToWithdraw) {

        System.out.println("Enter PIN first");
    }
}
