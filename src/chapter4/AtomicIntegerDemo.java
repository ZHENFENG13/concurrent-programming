package chapter4;

import java.util.concurrent.atomic.AtomicInteger;


public class AtomicIntegerDemo {
    static AtomicInteger i = new AtomicInteger();

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int j = 0; j < 10002; j++) {
                i.incrementAndGet();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {

        Thread[] threads = new Thread[10];

        for (int j = 0; j < 10; j++) {
            threads[j] = new Thread(new AddThread());
        }

        for (int j = 0; j < 10; j++) {
            threads[j].start();
        }
        for (int j = 0; j < 10; j++) {
            threads[j].join();
        }

        System.out.println(i);
    }
}
