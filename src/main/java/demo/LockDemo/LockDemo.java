package demo.LockDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    private Lock lock = new ReentrantLock();
    private void func(){
        lock.lock();
        try{
            for(int i = 0;i<10;i++){
                System.out.println(i +" ");
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockDemo lockDemo = new LockDemo();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->lockDemo.func());
        TimeUnit.SECONDS.sleep(5);
        executorService.execute(()->lockDemo.func());
        executorService.shutdown();
    }
}
