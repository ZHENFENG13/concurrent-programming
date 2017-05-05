package chapter3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 13 on 2017/5/5.
 */
public class TimeLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName());
                System.out.println("get lock success");
                Thread.sleep(6000);
            } else {
                System.out.println(Thread.currentThread().getName());
                System.out.println("get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    /**
     * À¯…Í«Îµ»¥˝œﬁ ±tryLock
     * @param args
     */
    public static void main(String args[]) {
        TimeLock timeLock = new TimeLock();
        Thread thread1 = new Thread(timeLock);
        Thread thread2 = new Thread(timeLock);

        thread1.start();
        thread2.start();
    }
}
