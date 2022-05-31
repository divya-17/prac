package LLD.DesignPatterns.strategyPattern;

public class DefendStrategy implements TeamStrategy {


    @Override
    public void play(String teamName) {
        System.out.println("Team "+teamName+" playing in defensive mode!");
    }
}
