package demo.Threadcollaboration;

import java.util.concurrent.TimeUnit;

public class JoinExample {
    private static class A extends Thread{
        @Override
        public void run() {
            System.out.println("A");
        }
    }
    private static class B extends Thread{
        private  A a;
        B(A a){
            this.a = a;
        }
        @Override
        public void run() {
            try {
                a.join();
                TimeUnit.SECONDS.sleep(10);
                a.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }
    public void test(){
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }

    public static void main(String[] args) {
        JoinExample joinExample = new JoinExample();
        joinExample.test();
    }
}
