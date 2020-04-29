package TheArtConcurrent.chapter4;

import java.util.ArrayList;
import java.util.List;

public class SimpleTimeOut {
    public synchronized void get(long s){
        String result = "等待时间超时";
        //等待次序时间
        long remaining = s;
        //超时时间
        long futrue = (System.currentTimeMillis()/1000)+s;
        int i = 0;
        while(remaining > 0){
            try {
                wait(remaining);
                remaining =futrue-(System.currentTimeMillis()/1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        new SimpleTimeOut().get(2);
    }
}
