package DesignPatterns.statePattern;

public class ThirdYearKid implements KidState {

    @Override
    public void eat() {
        System.out.println("Eat cholates");
    }

    @Override
    public void play() {

        System.out.println("Run and Roll");
    }
}
