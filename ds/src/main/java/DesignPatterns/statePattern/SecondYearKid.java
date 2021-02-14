package DesignPatterns.statePattern;

public class SecondYearKid implements KidState {
    @Override
    public void eat() {
        System.out.println("Eat potatoes");
    }

    @Override
    public void play() {
        System.out.println("Play with toys");
    }
}
