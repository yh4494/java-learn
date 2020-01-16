package conturrent.model.feture;

public class FetureTestMain extends Object {

    public static void main(String[] args) {
        Client client = new Client();
        // 理解返回一个FutureData
        Data data = client.request("name");
        System.out.println("请求完毕!");
        try {
            // 处理其他业务
            // 这个过程中，真是数据RealData组装完成，重复利用等待时间
            // Thread.sleep(2000);
        } catch (Exception e) {

        }
        //真实数据
        System.out.println(String.format("%s%s", "数据 = ", data.getResult()));
        new Thread(() -> System.out.println(String.format("%s%s", "数据 = ", data.getResult()))).start();
        System.out.println("执行完成");
    }

}
