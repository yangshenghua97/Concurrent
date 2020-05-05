package demo.executorDemo.ExecutorInterrupt;

import java.util.concurrent.*;

public class ExecutorInterruptDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future = executorService.submit(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Thread Run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        future.cancel(true);
        executorService.shutdownNow();
        System.out.println("Main run");
    }
}
