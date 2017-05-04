package chapter2;

/**
 * Created by 13 on 2017/5/4.
 */
public class VolatileDemo {
    static volatile int i = 0;

    public static class PlusTask implements Runnable {

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
            for (int j = 0; j < 10000; j++) {
                i++;
            }
        }
    }

    /**
     * volatile保证变量的可见性,但是无法保证一些符合操作的原子性,该实例里即能得到此结果,启动10个线程对i进行累加操作,
     * 如果一切正常的话,结果应为100000,但是结果为94875或者其他小于100000,因此线程的并发中没有保证i的原子性.
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[100];
        for (int j = 0; j < 100; j++) {
            threads[j] = new Thread(new PlusTask());
            threads[j].start();
        }
        for (int j = 0; j < 100; j++) {
            threads[j].join();
        }
        System.out.println(i);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("耗时:" + time);
    }
}
