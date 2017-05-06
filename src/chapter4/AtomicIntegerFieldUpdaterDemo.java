package chapter4;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by 13 on 2017/5/6.
 */
public class AtomicIntegerFieldUpdaterDemo {
    public static class Candidate {
        int id;
        volatile int score;
    }

    public final static AtomicIntegerFieldUpdater<Candidate> scoreUpdater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");
    //检查Updater是否工作正确
    public static AtomicInteger allScore = new AtomicInteger(0);

    public static void main(String args[]) throws InterruptedException {
        final Candidate stu = new Candidate();
        Thread[] t = new Thread[10000];

        for (int i = 0; i < 10000; i++) {
            t[i] = new Thread() {
                public void run() {
                    if (Math.random() > 0.4) {
                        scoreUpdater.incrementAndGet(stu);
                        allScore.incrementAndGet();
                    }
                }
            };
            t[i].start();
        }


        for (int i = 0; i < 10000; i++) {
            t[i].join();
        }
        System.out.println("score=" + stu.score);
        System.out.println("allScore=" + allScore);
    }


}
