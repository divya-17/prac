package LLD.snakeAndLadder;

public class Jumper {

    private int startLocation;
    private int endLocation;

    public Jumper(int startLocation, int endLocation) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    public int getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(int startLocation) {
        this.startLocation = startLocation;
    }

    public int getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(int endLocation) {
        this.endLocation = endLocation;
    }
}
