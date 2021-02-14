package DesignPatterns.statePattern;

public class FirstYearKid implements KidState {

    @Override
    public void eat() {
        System.out.println("Drink Milk");
    }

    @Override
    public void play() {
        System.out.println("Play with cradle");
    }
}
