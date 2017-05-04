package chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 13 on 2017/5/4.
 */
public class HashMapMultiThread {
    static Map<String, String> map = new HashMap<String, String>();

    public static class AddThread implements Runnable {

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
        int start = 0;

        public AddThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i < 100000; i += 2) {
                map.put(Integer.toString(i), Integer.toBinaryString(i));
            }
        }
    }

    /**
     *  HashMap是一个线程不安全的容器,多线程操作时会出现冲突
     *
     *  jdk7下谨慎运行此方法,可能会导致电脑死机,jdk8中问题已修复
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(new HashMapMultiThread.AddThread(0));
        Thread thread2 = new Thread(new HashMapMultiThread.AddThread(1));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(map.size());
    }
}
