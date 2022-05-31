package LLD.loggerFramework;

public class ErrorLogger extends AbstractLogger {


    public ErrorLogger(int logLevel){

        this.logLevel = logLevel;
    }
    @Override
    protected void display(String msg,LogSink logSink) {
        logSink.notifyObserver(1,"ERROR: "+msg);
    }
}
