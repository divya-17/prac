package LLD.loggerFramework;

import java.io.Serializable;

/*
Singleton design pattern
 */
public class Logger implements Cloneable, Serializable {

    private volatile static Logger logger;
    private volatile static AbstractLogger chainLogger;
    private volatile static LogSink logSink;

    private Logger(){
        if(logger != null){
            throw new IllegalStateException("Object already created");
        }
    }

    public static Logger getInstance(){

        if(logger == null){
            synchronized (Logger.class){
                if(logger == null){
                    logger = new Logger();
                    chainLogger = LogManager.buildChainOfLogger();
                    logSink = LogManager.buildLogSink();
                }
            }
        }
        return logger;
    }

    protected Object clone() throws CloneNotSupportedException {

        throw new CloneNotSupportedException();
    }

    protected Object readResolve(){
        return logger;
    }

    private void generateLog(int logLevel, String message){
        chainLogger.logMessage(logLevel,message,logSink);
    }

    public void info(String message){
       generateLog(2,message);
    }

    public void error(String message){
        generateLog(1,message);
    }

    public void debug(String message){
        generateLog(3,message);
    }
}
