package chapter2;

/**
 * Created by 13 on 2017/5/4.
 */
public class AccountSync implements Runnable {
    static AccountSync instance = new AccountSync();
    static volatile int i = 0;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            /**
             * synchronized的作用是实现线程间的同步,对同步的代码加锁,使得每一次都只能有一个线程进入同步块从而保证线程间的安全性.
             */
            synchronized (instance) {
                i++;
            }
        }
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(i);
    }
}
