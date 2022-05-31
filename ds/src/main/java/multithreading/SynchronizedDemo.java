package multithreading;

public class SynchronizedDemo {

    private static int count = 0;
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0; i < 10000; i++){
                    incrementCount();
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0; i < 10000; i++) {
                    incrementCount();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }

    public synchronized static void incrementCount(){
        count++;
    }
}
