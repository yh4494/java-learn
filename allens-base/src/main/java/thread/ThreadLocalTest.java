package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 测试ThreadLocal
 * @Author      Allens
 * @Date        2020-10-28 11:37
 * @Version     V1.0
 */
public class ThreadLocalTest {

    static ThreadLocal threadLocal = new ThreadLocal();


    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        threadLocal.set("some");
        pool.execute(() -> System.out.println(threadLocal.get()));
        pool.execute(() -> System.out.println(threadLocal.get()));
        Thread thread = new Thread();
        // thread.threadLocals;
    }
}
