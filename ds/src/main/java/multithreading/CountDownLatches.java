package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatches {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3);

        Process  process = new Process(latch);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i =0; i < 3; i++){
            executorService.submit(process);
        }

        try {
            // Blocks unless latch reaches to 0.
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Count down latch reached to 0");

    }
}
class Process implements Runnable{


    CountDownLatch countDownLatch;

    public Process(CountDownLatch latch){
        countDownLatch = latch;
    }
    @Override
    public void run() {

        System.out.println("Starting !");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Decrements the value of
        countDownLatch.countDown();
        System.out.println("Completed !");
    }
}
