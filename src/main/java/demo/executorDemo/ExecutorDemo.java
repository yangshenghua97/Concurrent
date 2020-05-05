package demo.executorDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newCachedThreadPool();
        for (int i = 0;i<40;i++){
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();
    }
}
