package LLD.snakeAndLadder;

public class Player {

    private int id;
    private String name;
    private int currLocation;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getCurrLocation() {
        return currLocation;
    }

    public void setCurrLocation(int currLocation) {
        this.currLocation = currLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
