package multithreading;

import javassist.bytecode.analysis.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
Executor service demo:
Executor service allows to start thread pool. There is lot of overhead in starting new threads.
Thread pool is a good way to recycle threads
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(int i =0; i <= 5; i++){
            executorService.submit(new Processor(i));
        }

        /*
        This only shuts down the managerial thread that started the thread pool. Actual threads that
        are performing tasks are still running.
         */
        executorService.shutdown();

        System.out.println("All tasks submitted !");

        /*
            This actually waits for the worker thread to complete. This is equivalent to thread.join()
         */
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All tasks completed !");

    }

}

class Processor implements Runnable{

    private int id;

    public Processor(int id){

        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting "+id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed "+id);
    }
}