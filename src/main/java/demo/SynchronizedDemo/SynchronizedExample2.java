package demo.SynchronizedDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedExample2 {
    public void func2(){
        synchronized (SynchronizedExample.class){
            for(int i = 0;i<20;i++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedExample2 e1 = new SynchronizedExample2();
        SynchronizedExample2 e2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->e1.func2());
        executorService.execute(()->e2.func2());
        executorService.shutdown();

    }
}
