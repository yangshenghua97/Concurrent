package chapter5;

public class ThreadCloseGraceful2 {
    private static class Worker extends Thread{
        public void run(){
            while(true){
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    break;
                }
            }

        }
        public static void main(String[] args) {
            Worker worker = new Worker();
            worker.start();
            try{
                Thread.sleep(10000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            worker.interrupt();
        }
    }
}
