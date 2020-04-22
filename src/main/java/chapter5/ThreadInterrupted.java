package chapter5;

public class ThreadInterrupted {
    private static final Object MONITOR = new Object();
    public static void main(String[] args){
        Thread main = Thread.currentThread();
        Thread t = new Thread(){
            @Override
            public void run() {
                while(true){

                }
            }
        };
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t.interrupt();
                System.out.println("interrupt");
            }
        };
        t1.start();
        try{
            main.join();
        }catch(InterruptedException e){

        }
        t.start();
    }
}
