package conturrent.model.masterworker;

import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@Data
public class Worker implements Runnable {

    private ConcurrentLinkedQueue<Task> workQueue;

    private ConcurrentHashMap<String, Object> resultMap;

    @Override
    public void run() {
        while (true) {
            // 取任务
            Task input = this.workQueue.poll();
            if (input == null) break;
            // 处理任务，可把这个方法变成抽象方法，具体的业务，继承Worker来实现
            Object output = handle(input);
            // 把处理结果放到Master的结果处理集里面
            this.resultMap.put(Integer.toString(input.getId()), output);
        }
    }

    private Object handle(Task input) {
        Object output = null;
        // 处理任务的耗时。。 比如说进行操作数据库。。。
        // Thread.sleep(500);
        output = input.getPrice();
        return output;
    }

}
