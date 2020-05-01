package TheArtConcurrent.chapter5.JavaLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDown {
    ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    Lock readlock = rwl.readLock();
    Lock writerlock = rwl.writeLock();
    volatile boolean  updata = false;
    public void processData(){
        if(!updata){
            readlock.unlock();
            writerlock.lock();
            try{
                if(!updata){
                    updata = true;
                }
                readlock.lock();
            }finally {
                writerlock.unlock();
            }
        }
    }
}
