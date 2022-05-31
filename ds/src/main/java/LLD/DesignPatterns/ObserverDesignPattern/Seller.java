package LLD.DesignPatterns.ObserverDesignPattern;

public class Seller implements Observer {

    private String location;

    @Override
    public void update(String location) {

        this.location = location;
        showLocation();

    }

    private void showLocation() {

        System.out.println("Seller is at location =>"+location);
    }
}
