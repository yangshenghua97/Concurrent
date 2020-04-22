package chapter4;

import java.util.Optional;

public class ThreadSimpleAPI1 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            Optional.of("Hello").ifPresent(System.out::println);
            try{
                Thread.sleep(60_000);
            }catch(InterruptedException ie){
            }
        },"t1");
        t.start();
        Optional.of(t.getName()).ifPresent(System.out::println);
        Optional.of(t.getId()).ifPresent(System.out::println);
        Optional.of(t.getPriority()).ifPresent(System.out::println);

    }
}
