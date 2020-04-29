package TheArtConcurrent.chapter4;

import sun.misc.ThreadGroupUtils;

import java.util.concurrent.TimeUnit;

public class Shutdown {
    public static void main(String[] args) throws InterruptedException {
        Runner on = new Runner();
        Thread countThread = new Thread(on,"CountThread1");
        countThread.start();
        TimeUnit.SECONDS.sleep(2);
        //打断
        countThread.interrupt();
//        Runner two = new Runner();
//        countThread = new Thread(two,"CountThread2");
//        countThread.start();
//        TimeUnit.SECONDS.sleep(1);
//        two.cancel();
    }
    static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;
        public void run() {
            while(on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("Count i = "+i);
        }
        public void cancel(){
            on = false;
        }
    }
}
