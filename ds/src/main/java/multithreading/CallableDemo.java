package multithreading;

import java.util.Random;
import java.util.concurrent.*;

/*
When we want thread to return some value we use Callable instead of Runnable.
Callable returns future object.
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> result = executorService.submit(new Callable<Integer>() {


            @Override
            public Integer call() throws Exception {

                Random random = new Random();
                Integer sleepDuration = random.nextInt(1000);

                System.out.println("Starting !! ");
                Thread.sleep(sleepDuration);
                System.out.println("Closing !! ");

                return sleepDuration;
            }
        });

        /*
            We can also write callable method to not return anything just to use
            other future funcs like future.isDone() which just checks if the thread is completed.
         */

        Future<?> result1 = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {

                Random random = new Random();
                Integer sleepDuration = random.nextInt(1000);

                System.out.println("Starting !! ");
                Thread.sleep(sleepDuration);
                System.out.println("Closing !! ");

                return null;
            }
        });
        executorService.shutdown();

        // Here future.get is a blocking func and it blocks until it doesn't get response back from the thread.
        System.out.println("Future result is "+result.get());
        System.out.println("Is thread done ! "+result1.isDone());
    }
}
