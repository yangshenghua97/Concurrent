package chapter5;

import java.util.LinkedList;

import static java.lang.Thread.currentThread;

public class EventQueue {
    private final int max;
    static class Event{}
    private final LinkedList<Event> eventQueue = new LinkedList<>();
    private final static int DEFAULT_MAX_EVENT = 10;
    public EventQueue(int max) {
        this.max = max;
    }
    public EventQueue() {
        this(DEFAULT_MAX_EVENT);
    }
    public void offer(Event event){
        synchronized (eventQueue){
            if(eventQueue.size() >= max){
                try {
                    System.out.printf("%s:%s\n",currentThread().getName(),"the queue is full");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.printf("%s:%s\n",currentThread().getName(),"the new event is sum");
            eventQueue.addLast(event);
            eventQueue.notify();
        }
    }
    public Event take(){
        synchronized (eventQueue) {
            if(eventQueue.isEmpty()){
                try {
                    System.out.printf("%s:%s\n",
                            currentThread().getName(),
                            "the queue is empty");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
            this.eventQueue.notify();
            System.out.printf("%s:%s\n",currentThread().getName(),
                    "the event"+event+"is handled");
            return event;
        }

    }

}
