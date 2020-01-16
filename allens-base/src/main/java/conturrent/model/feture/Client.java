package conturrent.model.feture;

public class Client {

    public Data request(final String queryStr){
        final FutureData future = new FutureData();
        //开启一个新的线程来构造真实数据
        new Thread(() -> {
            RealData realData = new RealData(queryStr);
            future.setRealData(realData);
        }).start();
        return future;
    }

}
