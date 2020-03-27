package conturrent.atomic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    private volatile int someNumber1 = 0;

    private static int someNumber2 = 0;

    private static AtomicInteger someNumber3 = new AtomicInteger(0);

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(100);

    private static int IncreaseInteger = 1000;

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        ExecutorService ex = Executors.newCachedThreadPool();
        for (int i = 0; i < IncreaseInteger; i ++) {
            ex.execute(() -> {
                atomicIntegerTest.someNumber1 = atomicIntegerTest.someNumber1 + 1;
                exeAwait();
            });
        }

        for (int i = 0; i < IncreaseInteger; i ++) {
            ex.execute(() -> {
                someNumber2 ++;
                exeAwait();
            });
        }

        for (int i = 0; i < IncreaseInteger; i ++) {
            ex.execute(() -> {
                someNumber3.incrementAndGet();
                exeAwait();
            });
        }

        Thread.sleep(2000);
        System.out.println(atomicIntegerTest.someNumber1);
        System.out.println(someNumber2);
        System.out.println(someNumber3);
        ex.shutdown();
    }

    public static void exeAwait () {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
