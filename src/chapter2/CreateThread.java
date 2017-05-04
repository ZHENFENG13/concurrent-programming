package chapter2;

/**
 * Created by 13 on 2017/5/4.
 */
public class CreateThread implements Runnable {
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
        System.out.println("Hi!I am Runnable");
    }

    public static void main(String args[]) {
        Thread thread = new Thread(new CreateThread());
        thread.start();
    }
}
