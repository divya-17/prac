package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleLocksDemo {

    public static void main(String[] args) {

        Worker w = new Worker();
        w.main();

    }
}

class Worker{

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    // Multiple locks.
    Object lock1 = new Object();
    Object lock2 = new Object();


    public void main() {
        Worker worker = new Worker();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                worker.process();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                worker.process();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("List 1 size "+list1.size());
        System.out.println("List 2 size "+list2.size());
        // worker.process();
    }

    public void stageOne(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock1) {
            list1.add(new Random().nextInt(1000));
        }

    }
    public void stageTwo(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock2) {
            list2.add(new Random().nextInt(1000));
        }

    }

    public void process(){
        for(int i =0; i < 1000; i++){
            stageOne();
            stageTwo();
        }
    }



}
