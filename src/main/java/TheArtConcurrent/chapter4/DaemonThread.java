package TheArtConcurrent.chapter4;

import java.util.concurrent.TimeUnit;

public class DaemonThread {
    public static void main(String[] args) {
       Thread thread = new Thread(new Daemon(),"DaemonRunner");
       thread.setDaemon(true);
       thread.start();
    }
    static class Daemon implements Runnable{
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
