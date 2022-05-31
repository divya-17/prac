package LLD.loggerFramework;

public class DebugLogger extends AbstractLogger {


    public DebugLogger(int logLevel){
        this.logLevel = logLevel;
    }

    @Override
    protected void display(String msg,LogSink logSink) {
        logSink.notifyObserver(3,"DEBUG: "+msg);
    }
}
