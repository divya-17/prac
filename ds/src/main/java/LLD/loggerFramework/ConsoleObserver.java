package LLD.loggerFramework;

public class ConsoleObserver implements LogObserver {

    @Override
    public void logSink(String message) {

        System.out.println("CONSOLE: "+message);

    }
}
