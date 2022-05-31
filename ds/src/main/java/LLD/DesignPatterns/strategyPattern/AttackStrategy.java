package LLD.DesignPatterns.strategyPattern;

class AttackStrategy implements TeamStrategy {


    @Override
    public void play(String teamName) {

        System.out.println("Team "+teamName+" playing in attacking mode !");
    }
}
