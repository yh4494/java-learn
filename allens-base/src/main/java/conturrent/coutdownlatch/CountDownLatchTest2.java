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
public class CountDownLatchTest2 {

    private static Integer cpu =  Runtime.getRuntime().availableProcessors() * 2;

    private static ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap();

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

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

    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ExecutorService ex = Executors.newFixedThreadPool(5);
        ex.execute(() -> {
            for (int i = 50; i < 100; i ++) {
                System.out.println(i);
                countDownLatch.countDown();
            }
        });
        Thread.sleep(10);
        for (int i = 0; i < 50; i ++) {
            System.out.println(i);
        }

        countDownLatch.await();
    }

}
