package chapter4;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by 13 on 2017/5/6.
 */
public class AtomicInterArrayDemo {
    static AtomicIntegerArray array = new AtomicIntegerArray(10);

    public static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                array.getAndIncrement(i % array.length());
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new AddThread());
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
            System.out.println(array);
        }
    }
}
