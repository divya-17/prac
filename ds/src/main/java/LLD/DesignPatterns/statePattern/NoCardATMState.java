package LLD.DesignPatterns.statePattern;

public class NoCardATMState implements ATMState{

    ATMMachine atmMachine;

    public NoCardATMState(ATMMachine atmMachine){
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {

        System.out.println("Card inserted successfully. Please enter the pin");
        atmMachine.setATMState(atmMachine.getHasCardState());
    }

    @Override
    public void ejectCard() {
        System.out.println("Enter the card first. No card in the machine");
    }

    @Override
    public void enterPin(int pinCode) {

        System.out.println("Enter card first. No card in the machine");
    }

    @Override
    public void requestCash(int cashToWithdraw) {

        System.out.println("Enter the card first. No card in the machine");
    }
}
