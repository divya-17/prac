package LLD.DesignPatterns.statePattern;

public class ATMMachineTest {

    public static void main(String[] args) {

        ATMMachine atmMachine = new ATMMachine();

        atmMachine.insertCard();
        atmMachine.ejectCard();
        atmMachine.insertCard();
        atmMachine.enterPin(1234);
        atmMachine.requestCash(2000);
        atmMachine.insertCard();
        atmMachine.enterPin(1234);
    }



}
