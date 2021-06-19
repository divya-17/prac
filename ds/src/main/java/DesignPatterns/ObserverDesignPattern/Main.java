package DesignPatterns.ObserverDesignPattern;

public class Main {

    public static void main(String[] args) {


        Subject deliveryLocation = new DeliveryLocation();

        Observer user = new User();
        Observer seller = new Seller();
        Observer wareHouse = new DeliveryWareHouse();

        deliveryLocation.register(user);
        deliveryLocation.register(seller);
        deliveryLocation.register(wareHouse);

        ((DeliveryLocation)deliveryLocation).setLocation("USA");

        ((DeliveryLocation)deliveryLocation).setLocation("LONDON");

        deliveryLocation.unregister(wareHouse);

        ((DeliveryLocation)deliveryLocation).setLocation("FRANCE");
    }
}
