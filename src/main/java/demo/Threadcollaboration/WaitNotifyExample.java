package demo.Threadcollaboration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitNotifyExample {
    /*
    wait(),notify(),notifyAll()只能在同步方法或同步控制块中使用
    否则会抛出异常
     */
    public synchronized void before(){
        System.out.println("before");
        notifyAll();
    }
    public synchronized void after(){
        try{
            wait();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        WaitNotifyExample example = new WaitNotifyExample();
        executorService.execute(()->example.after());
        executorService.execute(()->example.before());
    }
}
