package DesignPatterns.strategyPattern;

public class Main {


    public static void main(String[] args) {

        Team teamGerman = new TeamGerman();
        Team teamArgentina = new TeamArgentina();

        TeamStrategy attackStrategy = new AttackStrategy();
        TeamStrategy defendStrategy = new DefendStrategy();

        teamGerman.setTeamStrategy(attackStrategy);
        teamArgentina.setTeamStrategy(defendStrategy);

        teamGerman.teamInfo();
        teamGerman.play("German");
        teamArgentina.teamInfo();
        teamArgentina.play("Argentina");

        System.out.println();

        teamGerman.setTeamStrategy(defendStrategy);
        teamArgentina.setTeamStrategy(attackStrategy);

        System.out.println("After Half time");

        System.out.println();

        teamGerman.teamInfo();
        teamGerman.play("German");
        teamArgentina.teamInfo();
        teamArgentina.play("Argentina");
    }

}


