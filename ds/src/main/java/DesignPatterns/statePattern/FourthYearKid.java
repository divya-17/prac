package DesignPatterns.statePattern;

public class FourthYearKid implements KidState {

    @Override
    public void eat() {
        System.out.println("Eat cakes");
    }

    @Override
    public void play() {
        System.out.println("Play football");
    }
}
