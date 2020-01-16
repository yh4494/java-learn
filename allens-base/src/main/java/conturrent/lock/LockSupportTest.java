package conturrent.lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            LockSupport.park();
            System.out.println("hello 1");
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            LockSupport.park(2000);
            System.out.println("hello 2");
        });
        t2.start();

        LockSupport.unpark(t1);
        Thread.sleep(2000);
        LockSupport.unpark(t2);

    }

}
