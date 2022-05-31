package LLD.loggerFramework;

import java.util.*;

public class LogSink {

    private Map<Integer,List<LogObserver>> logObserverMap = new HashMap<>();


    public void addObserver(int logLevel, LogObserver logObserver){

        if(logObserverMap.containsKey(logLevel)){
            logObserverMap.get(logLevel).add(logObserver);
        }
        else{
            logObserverMap.put(logLevel,new ArrayList<>(Arrays.asList(logObserver)));
        }
    }

    public void notifyObserver(int logLevel,String message){

        if(logObserverMap.containsKey(logLevel)) {
            for (LogObserver logObserver : logObserverMap.get(logLevel)) {
                logObserver.logSink(message);
            }
        }
    }
}
