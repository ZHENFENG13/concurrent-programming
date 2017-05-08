package chapter5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by 13 on 2017/5/8.
 */
public class FutureMain {

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        //构造FutureTask
        FutureTask<String> futureTask = new FutureTask<String>(new RealData2("a"));

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        //执行FutureTask,相当于前一个例子中的client.request("a")发送请求
        //在这里开启线程进行RealData的call()执行
        executorService.submit(futureTask);

        System.out.println("请求完毕");

        try {
            //这里依然可以做额外的数据操作,使用sleep代替其他业务逻辑的处理
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //相当于前一个例子中的data.getResult(),取得call()方法的返回值
        //如果此时call()方法没有执行完成,则依然会等待
        System.out.println("数据=" + futureTask.get());
    }
}
