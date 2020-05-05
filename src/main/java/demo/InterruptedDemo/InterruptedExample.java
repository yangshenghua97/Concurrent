package demo.InterruptedDemo;

public class InterruptedExample {
    static Thread thread1 = new Thread(()->{
        try {
            Thread.sleep(10000);
            System.out.println("Thread run");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    public static void main(String[] args) {
        thread1.start();
        thread1.interrupt();
        System.out.println("Main Run");
    }
}
