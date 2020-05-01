package TheArtConcurrent.chapter7;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {
    static int[] value = {1,2,3};
    static AtomicIntegerArray aia = new AtomicIntegerArray(value);
    public static void main(String[] args) {
        //更新数组0位置的值为0
        aia.getAndSet(0,0);
        System.out.println(aia.get(0));
        System.out.println(value[0]);
    }
}
