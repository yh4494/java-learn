package conturrent.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 测试类
 * @Author Allens
 * @Date 2020-09-10 13:50
 * @Version V1.0
 */
public class ReentrantLockTest {

    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Condition condition1 = reentrantLock.newCondition();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition1.notify();
        });
        condition1.await();
    }

}
