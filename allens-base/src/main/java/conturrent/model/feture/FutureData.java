package conturrent.model.feture;

public class FutureData implements Data {

    protected RealData realData = null;  // 真实数据
    protected boolean isReady   = false; // 记录是否可以返回的状态

    public synchronized void setRealData(RealData realData){
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();
    }

    @Override
    public synchronized String getResult() {
        while (!isReady) {
            System.out.println("--------------------方法等待中-------------------");
            try {
                wait();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return realData.result;
    }

}
