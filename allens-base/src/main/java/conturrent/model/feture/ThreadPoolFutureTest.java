package conturrent.model.feture;

import java.util.HashMap;
import java.util.concurrent.*;

public class ThreadPoolFutureTest {

    private static HashMap callableMap = new HashMap();

    static class CustomCallable implements Callable {

        private Integer index;

        public CustomCallable(int i) {
            index = i;
        }

        @Override
        public Object call() throws Exception {
            return index;
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
        Callable callable = () -> {
            System.out.println("Execute callable!!!");
            return "Talk to someone!";
        };

        for (int i = 0; i < 10; i ++) {
            Future<String> result = threadPoolExecutor.submit(new CustomCallable(i));
            callableMap.put(i, result);
            // if (i == 5) result.cancel(true);
        }

        {
            Future<String> result = (Future<String>) callableMap.get(5);
            if (!result.isDone()) {
                result.cancel(true);
                System.out.println("result:" + result.isCancelled());
            }
        }

        try {
            for (Object e : callableMap.entrySet()) {
                Future<String> result = ((HashMap.Entry<Integer, Future<String>>) e).getValue();
                if (!result.isCancelled()) {
                    System.out.println(String.valueOf(result.get(1000, TimeUnit.MICROSECONDS)));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
            System.out.println("Close");
        }
    }

}
