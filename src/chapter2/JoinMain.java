package chapter2;

/**
 * Created by 13 on 2017/5/4.
 */
public class JoinMain {
    public volatile static int i = 0;

    public static class AddThread extends Thread {
        public void run() {
            System.out.println("add!");
            for (i = 0; i < 1000000; i++) ;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {

        AddThread at = new AddThread();
        at.start();
        at.join();//使用join()方法后,主线程会等待AddThread执行完毕,i输出为1000000,如果没有这条语句,i输出为0
        //可以查看join的底层代码,本质即让调用线程在当前线程对象实例上等待
        System.out.println(i);
    }
}
