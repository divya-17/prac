package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
Initially threads had stop method but that would shut down the thread ungracefully so stop() has been
deprecated and we use thread.interrupt() instead. thread.interrupt() actually sets the interrupt flag to true so
inside the thread we need to check for this flag periodically and if set to true that would mean we need to return from
the thread
 */
public class ThreadInterruptDemo {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();

        Future<?> res = service.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {

                System.out.println("Starting");

                // This loop will run for too long (about a min)
                for (int i = 0; i < 1E10; i++) {

                    // Check for the flag
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Thread has been interrupted!");
                        break;
                    }
                    Math.sin(i);
                }
                System.out.println("Stopping");
                return null;
            }
        });

        // Wait for 5 sec
        Thread.sleep(5000);

        // Interrupt the thread.
        /*
        shutdownNow() interrupts all the running threads. Other ways to interrupt is future.cancel().
         */
        service.shutdownNow();

        service.shutdown();


    }
}
