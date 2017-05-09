package chapter5.parallel_compute;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by 13 on 2017/5/9.
 */
public class Plus implements Runnable {

    public static BlockingDeque<Msg> blockingDeque = new LinkedBlockingDeque<Msg>();

    @Override
    public void run() {
        while (true) {
            Msg msg = null;
            try {
                msg = blockingDeque.take();
                msg.i = msg.j + msg.i;
                Multiply.blockingDeque.add(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
