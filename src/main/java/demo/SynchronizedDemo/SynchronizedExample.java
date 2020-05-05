package demo.SynchronizedDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedExample {
    public void func1(){
        synchronized (this){
            for(int i = 0;i<20;i++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->e1.func1());
        TimeUnit.SECONDS.sleep(2);
        executorService.execute(()->e2.func1());
        executorService.shutdownNow();
    }
}
