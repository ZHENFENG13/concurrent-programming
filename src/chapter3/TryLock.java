package chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 13 on 2017/5/5.
 */
public class TryLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        if (lock == 1) {
            while (true) {
                if (lock1.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (lock2.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getId() + ":My Job done;");
                                return;
                            } finally {
                                lock2.unlock();
                            }
                        }
                    } finally {
                        lock1.unlock();
                    }
                }
            }
        } else {
            while (true) {
                if (lock2.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (lock1.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getId() + ":My Job done;");
                                return;
                            } finally {
                                lock1.unlock();
                            }
                        }
                    } finally {
                        lock2.unlock();
                    }
                }
            }

        }
    }

    /**
     * 上面代码中采用了非常容易死锁的加锁顺序,导致thread1和thread2由于锁的竞争而互相等待从而引起死锁
     *
     * 使用了tryLock后,线程不会一直等待而是不停的尝试去获得锁资源,只需要等待一定的时间,线程最终会获得所需要的资源
     *
     * @param args
     */
    public static void main(String args[]) {
        TryLock r1 = new TryLock(1);
        TryLock r2 = new TryLock(2);
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);

        thread1.start();
        thread2.start();
    }

}
