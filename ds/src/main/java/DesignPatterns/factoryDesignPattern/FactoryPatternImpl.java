package DesignPatterns.factoryDesignPattern;

public class FactoryPatternImpl {

    public static void main(String[] args) {

        Vehicle car = VehicleFactory.getInstance("car");

        System.out.println(car);

        Vehicle bike = VehicleFactory.getInstance("bike");

        System.out.println(bike);
    }
}
