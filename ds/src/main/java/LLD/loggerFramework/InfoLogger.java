package LLD.loggerFramework;

public class InfoLogger extends AbstractLogger {


    public InfoLogger(int level){
        this.logLevel=level;
    }

    @Override
    protected void display(String msg,LogSink logSink) {
        logSink.notifyObserver(2,"INFO: "+msg);
    }
}
