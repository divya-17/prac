package LLD.loggerFramework;

import scala.collection.immutable.Stream;

public class LogManager {

    public static AbstractLogger buildChainOfLogger(){

        ErrorLogger errorLogger = new ErrorLogger(1);
        InfoLogger infoLogger = new InfoLogger(2);
        DebugLogger debugLogger = new DebugLogger(3);

        errorLogger.setNextLevelLogger(infoLogger);
        infoLogger.setNextLevelLogger(debugLogger);

        return errorLogger;
    }

    public static LogSink buildLogSink(){

        ConsoleObserver consoleObserver = new ConsoleObserver();
        FileObserver fileObserver = new FileObserver();

        LogSink sink = new LogSink();

        sink.addObserver(1,consoleObserver);
        sink.addObserver(1,fileObserver);

        sink.addObserver(2,fileObserver);
        return sink;
    }
}
