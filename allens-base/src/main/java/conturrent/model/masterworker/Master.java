package conturrent.model.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class Master {

    // 1 有一个盛放任务的容器
    private ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue<Task>();

    // 2 需要有一个盛放worker的集合，可以用线程池Excutor
    private HashMap<String, Runnable> workers = new HashMap<String, Runnable>();

    /**
     * int corePoolSize,
     * int maximumPoolSize,
     * long keepAliveTime,
     * TimeUnit unit,
     * BlockingQueue<Runnable> workQueue
     */
    private ThreadPoolExecutor threadPoolExecutor;

    // 线程池队列设置
    private LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque(100);

    // 3 需要有一个盛放每一个worker执行任务的结果集合
    private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<String, Object>();

    // 4 构造方法,创建master和指定个数的worker
    public Master(int workerCount){
        threadPoolExecutor = new ThreadPoolExecutor(workerCount, workerCount * 2, 10000, TimeUnit.MICROSECONDS, linkedBlockingDeque);
        Worker worker = new Worker();
        worker.setWorkQueue(workQueue);
        worker.setResultMap(resultMap);

        for(int i = 0; i < workerCount; i ++){
            // threadPoolExecutor.execute(new Thread(worker));
            this.workers.put(Integer.toString(i), worker);
        }
    }

    // 5 需要一个提交任务的方法
    public void submit(Task task){
        this.workQueue.add(task);
    }

    // 6 需要有一个执行的方法，启动所有的worker方法去执行任务
    public void execute(){
        for (Map.Entry<String, Runnable> me : workers.entrySet()) {
            threadPoolExecutor.execute(me.getValue());
            // System.out.println("------------------------------");
            // me.getValue().start();
        }
    }

    // 7 判断是否运行结束的方法
    public boolean isComplete() {

        // System.out.println(threadPoolExecutor.isTerminated());
        // System.out.println(threadPoolExecutor.isShutdown());
        // System.out.println(threadPoolExecutor.getActiveCount());

        if (threadPoolExecutor.getActiveCount() != 0) {
            return false;
        }

        /*
        for(Map.Entry<String, Runnable> me : workers.entrySet()){
            if(me.getValue().getState() != Thread.State.TERMINATED){
                return false;
            }
        }
        */
        return true;
    }

    // 8 计算结果方法
    public int getResult() {
        int priceResult = 0;
        for(Map.Entry<String, Object> me : resultMap.entrySet()){
            priceResult += (Integer) me.getValue();
        }
        return priceResult;
    }

    public void shutDown() {
        threadPoolExecutor.shutdown();
    }
}
