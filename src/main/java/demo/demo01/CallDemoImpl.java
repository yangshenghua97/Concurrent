package demo.demo01;

import java.util.concurrent.Callable;

public class CallDemoImpl implements Callable<Integer> {
    @Override
    public Integer call() {
        return 25;
    }
}
