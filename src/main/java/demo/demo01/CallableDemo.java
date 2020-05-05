package demo.demo01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallDemoImpl ci = new CallDemoImpl();
        FutureTask<Integer> ft = new FutureTask<>(ci);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }
}
