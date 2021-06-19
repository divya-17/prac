package DesignPatterns.ObserverDesignPattern;

public class DeliveryWareHouse implements Observer {


    private String location;

    @Override
    public void update(String location) {

        this.location = location;
        showLocation();
    }

    private void showLocation() {

        System.out.println("Delivery warehouse is at location =>"+location);
    }
}
