package TheArtConcurrent.chapter4;

public class Synchronized {
    public static void main(String[] args) {
        //对Synchronized对象加锁
        synchronized (Synchronized.class){}
        m();
    }

    public static synchronized void m(){}
}
