package LLD.loggerFramework;

/*
Chain of responsibility design pattern
 */
public abstract class AbstractLogger {

    int logLevel;
    AbstractLogger nextLevelLogger;

    public AbstractLogger getNextLevelLogger() {
        return nextLevelLogger;
    }

    public void setNextLevelLogger(AbstractLogger nextLevelLogger) {
        this.nextLevelLogger = nextLevelLogger;
    }


    public void logMessage(int logLevel, String message,LogSink logSink){

        if(this.logLevel <= logLevel){
            display(message,logSink);
        }

        if(nextLevelLogger != null) {
            nextLevelLogger.logMessage(logLevel, message, logSink);
        }

    }

    protected abstract void display(String msg,LogSink logSink);
}
