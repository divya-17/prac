package DesignPatterns.singleton;

// Eager initialization
public class SingletonEager {

    private static SingletonEager instance = new SingletonEager();

    private SingletonEager(){}

    public SingletonEager getInstance(){
        return instance;
    }
}


