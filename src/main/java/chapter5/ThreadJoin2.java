package chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

public class ThreadJoin2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try{
                System.out.println("T1 is runnig");
                Thread.sleep(10_000);
                System.out.println("T1 is done");
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
        });
        t1.start();
        t1.join(1000,10);
        Optional.of("All of tasks finish done").ifPresent(System.out::println);
        IntStream.range(1,1000).forEach(i -> System.out.println(Thread.currentThread().getName()+"->"+i));
        Thread.currentThread().join();
    }
}
