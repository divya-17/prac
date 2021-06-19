package DesignPatterns.singleton;

public class SingletonSynchronisedBlock {


    private static SingletonSynchronisedBlock instance;

    private SingletonSynchronisedBlock(){}

    public SingletonSynchronisedBlock getInstance(){

        if(instance == null){
            synchronized (SingletonSynchronisedBlock.class){
                if(instance == null){
                    instance = new SingletonSynchronisedBlock();
                }
            }
        }
        return instance;
    }
}
