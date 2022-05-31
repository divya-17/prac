package LLD.loggerFramework;

public class FileObserver implements LogObserver {

    @Override
    public void logSink(String message) {
        System.out.println("FILE: "+message);
    }
}
