package conturrent.coutdownlatch;

import lombok.Data;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 底层使用CAS做控制
 */
public class CountDownLatchTest {

    private static Integer cpu =  Runtime.getRuntime().availableProcessors() * 2;

    private static ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap();

    private static CountDownLatch countDownLatch = new CountDownLatch(1000);

    @Data
    static class CustomRunable implements Runnable {

        private Integer price;

        private Integer id;

        public CustomRunable(Integer price, Integer id) {
            this.price = price;
            this.id = id;

        }

        @Override
        public void run() {
            concurrentHashMap.put(id, price);
            countDownLatch.countDown();
        }
    }

    private static long count () {
        return Arrays.stream(concurrentHashMap.values().toArray())
                .parallel()
                .mapToInt(value -> (int) value)
                .sum();
    }

    public static void main(String[] args) {
        // 创建线程池
        ExecutorService ex = null;
        try {
            ex = Executors.newFixedThreadPool(cpu);
            for (int i = 0; i < 1000; i ++) {
                ex.execute(new CustomRunable(i, i));
            }
            countDownLatch.await();
            System.out.println(count());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (ex != null) {
                ex.shutdown();
            }
        }

    }

}
