package chapter2;

/**
 * Created by 13 on 2017/5/4.
 */
public class DaemonDemo {
    public static class DaemonT extends Thread {
        public void run() {
            while (true) {
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * thread被设置为守护线程,系统中只有主线程main为用户线程,因此在main线程休眠3秒退出时,整个程序也随之结束,如果不把线程thread设置为守护线程,
     * main线程结束后,t线程还会不停的打印,永远也不会结束.
     *
     * tip:当一个Java应用内,只有守护线程时,Java虚拟机就会退出.
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        Thread thread = new DaemonT();
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(3000);

    }
}
