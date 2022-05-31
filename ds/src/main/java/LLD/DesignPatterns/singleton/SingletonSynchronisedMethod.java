package LLD.DesignPatterns.singleton;

public class SingletonSynchronisedMethod {

    private static SingletonSynchronisedMethod instance;

    private SingletonSynchronisedMethod(){}

    public synchronized SingletonSynchronisedMethod getInstance(){

        if(instance == null){
            instance = new SingletonSynchronisedMethod();
        }
        return instance;
    }
}
