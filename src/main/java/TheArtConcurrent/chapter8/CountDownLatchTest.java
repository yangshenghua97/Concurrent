package TheArtConcurrent.chapter8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
        public static void main(String[] args) throws InterruptedException {
        final int totalThread = 20;
        CountDownLatch cdl = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i<10;i++){
//          while(true){
            executorService.execute(()->{
                System.out.println("Thread Go..Go..");
                //每次调用计数器都会-1
                cdl.countDown();
        });
        }
        cdl.await(5,TimeUnit.SECONDS);
        System.out.println("end");
        executorService.shutdown();
    }
}
