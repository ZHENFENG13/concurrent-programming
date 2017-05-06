package chapter4;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by 13 on 2017/5/6.
 */
public class ThreadLocalDemo {
    public static final int GE_COUNT = 10000000;
    public static final int THREAD_COUT = 4;

    static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUT);
    public static Random random = new Random(123);

    public static ThreadLocal<Random> randomThreadLocal = new ThreadLocal<Random>() {
        protected Random initialValue() {
            return new Random(123);
        }
    };


    public static class RandomTask implements Callable<Long> {

        private int mode = 0;

        public RandomTask(int mode) {
            this.mode = mode;
        }

        public Random getRandom() {
            if (mode == 0) {
                return random;
            } else if (mode == 1) {
                return randomThreadLocal.get();
            } else {
                return null;
            }
        }


        @Override
        public Long call() throws Exception {
            long b = System.currentTimeMillis();

            for (int i = 0; i < GE_COUNT; i++) {
                getRandom().nextInt();
            }
            long e = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " spend" + (e - b) + "ms");
            return e - b;
        }
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        Future<Long>[] futures = new Future[THREAD_COUT];
        for (int i = 0; i < THREAD_COUT; i++) {
            futures[i] = executorService.submit(new RandomTask(0));
        }

        long totalTime = 0;

        for (int i = 0; i < THREAD_COUT; i++) {
            totalTime += futures[i].get();
        }
        System.out.println("多线程访问同一个Random实例:" + totalTime + "ms");

        //ThreadLocal的情况
        for (int i = 0; i < THREAD_COUT; i++) {
            futures[i] = executorService.submit(new RandomTask(1));
        }
        totalTime = 0;
        for (int i = 0; i < THREAD_COUT; i++) {
            totalTime += futures[i].get();
        }
        System.out.println("使用ThreadLocal包装Random实例:" + totalTime + "ms");

    }
}
