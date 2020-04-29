package chapter5;

import java.util.concurrent.TimeUnit;

public class EventClien {
    public static void main(String[] args) {
        final EventQueue eventQueue = new EventQueue();
        new Thread(()->{
            for(;;){
                eventQueue.offer(new EventQueue.Event());
            }
        },"Pr").start();
        new Thread(()->{
           for(;;){
               eventQueue.take();
               try {
                   TimeUnit.SECONDS.sleep(5 );
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        },"Consumer").start();
    }
}
