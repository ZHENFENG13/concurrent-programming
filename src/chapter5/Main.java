package chapter5;

/**
 * Created by 13 on 2017/5/8.
 */
public class Main {
    public static void main(String args[]) {
        Client client = new Client();
        //这里会立即返回,因为得到的是FutureData而不是RealData
        Data data = client.request("name");
        System.out.println("请求完毕");

        try {

            //这里用一个sleep代替了对其他业务逻辑的处理
            //在处理这些业务逻辑的过程中,RealData被创建,从而充分利用了等待时间
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //使用真实的数据
        System.out.println("数据=" + data.getResult());
    }
}
