package conturrent.atomic;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest2 {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newCachedThreadPool();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 100000; i ++) threadPool.submit(() -> {
            atomicInteger.updateAndGet((v) -> v + 1);
        });

        for (int i = 0; i < 100000; i ++) threadPool.submit(() -> {
            atomicInteger.updateAndGet((v) -> v + 1);
        });

        for (int i = 0; i < 100000; i ++) threadPool.submit(() -> {
            atomicInteger.updateAndGet((v) -> v + 1);
        });

        System.out.println(atomicInteger);
    }

}
