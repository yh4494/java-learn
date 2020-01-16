package conturrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static Condition condition1 = reentrantLock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                if (reentrantLock.tryLock()) {
                    Thread.sleep(1000);
                    System.out.println("hello 1");
                    reentrantLock.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    if (reentrantLock.tryLock()) {
                        Thread.sleep(1000);
                        System.out.println("hello 2");
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
