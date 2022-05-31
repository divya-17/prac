package LLD.DesignPatterns.factoryDesignPattern;

public class Bike implements Vehicle {

    private int wheel;

    public Bike(int wheel){
        this.wheel=wheel;
    }

    @Override
    public int getWheel() {
        return wheel;
    }

    @Override
    public String toString() {
        return "Bike has "+getWheel()+" wheels";
    }
}
