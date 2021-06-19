package DesignPatterns.factoryDesignPattern;

public class Car implements Vehicle {

    private int wheel;

    public Car(int wheel){
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return wheel;
    }

    @Override
    public String toString() {
        return "Car has "+getWheel()+" wheels";
    }
}
