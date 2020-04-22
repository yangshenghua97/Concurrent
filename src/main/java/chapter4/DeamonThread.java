package chapter4;

import java.util.concurrent.TimeUnit;

public class DeamonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            try{
                System.out.println(Thread.currentThread().getName()+"Runnig");
                TimeUnit.SECONDS.sleep(50);
                System.out.println(Thread.currentThread().getName()+"Done");
            }catch(InterruptedException ie){
            }
        });
        t.setDaemon(true);
        t.start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("main Thread done");
    }
}
