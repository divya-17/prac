package LLD.DesignPatterns.factoryDesignPattern;

public class VehicleFactory {

    public static Vehicle getInstance(String name){

        if(name.equalsIgnoreCase("car")){
            return new Car(4);
        }
        else if(name.equalsIgnoreCase("bike")){
            return new Bike(2);
        }

        return null;
    }
}
