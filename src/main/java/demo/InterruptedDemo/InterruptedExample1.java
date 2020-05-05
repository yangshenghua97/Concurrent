package demo.InterruptedDemo;

import java.util.concurrent.TimeUnit;

public class InterruptedExample1 {
    static Thread thread2 = new Thread(){
        @Override
        public void run() {
            while(!interrupted()){
                System.out.println(Thread.currentThread().getName()+" NO InTerrupt");
            }
            System.out.println(Thread.currentThread().getName()+" Interrupt");
        }
    };
    public static void main(String[] args) throws InterruptedException {
        thread2.start();
        TimeUnit.SECONDS.sleep(3);
        thread2.interrupt();
        System.out.println("Main Run");
    }
}
