package LLD.DesignPatterns.strategyPattern;

public abstract class Team {

    String teamName;
    TeamStrategy teamStrategy;


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public TeamStrategy getTeamStrategy() {
        return teamStrategy;
    }

    public void setTeamStrategy(TeamStrategy teamStrategy) {
        this.teamStrategy = teamStrategy;
    }

    public abstract void teamInfo();

    public void play(String teamName){
        teamStrategy.play(teamName);
    }


}
