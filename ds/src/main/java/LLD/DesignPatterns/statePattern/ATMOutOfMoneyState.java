package LLD.DesignPatterns.statePattern;

public class ATMOutOfMoneyState implements ATMState {

    ATMMachine atmMachine;

    public ATMOutOfMoneyState(ATMMachine atmMachine){
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {

        System.out.println("No Cash Left !");

    }

    @Override
    public void ejectCard() {

        System.out.println("We don't have Money. You didn't entered a card");
    }

    @Override
    public void enterPin(int pinCode) {

        System.out.println("We don't have Money");
    }

    @Override
    public void requestCash(int cashToWithdraw) {

        System.out.println("We don't have Money");
    }
}
