package DesignPatterns.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class DeliveryLocation implements Subject {

    List<Observer> observerList = new ArrayList<>();
    String location;


    @Override
    public void register(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {

        for(Observer observer: observerList){
            observer.update(this.location);
        }
    }

    public void setLocation(String location){

        this.location = location;
        notifyObserver();
    }
}
