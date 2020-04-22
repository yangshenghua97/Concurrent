package chapter5;

public class ThreadService {
    private Thread executeThread;
    private boolean finished = false;
    public void execute(Runnable task){
        executeThread = new Thread(){
            @Override
            public void run() {
                Thread runne = new Thread(task);
                runne.setDaemon(true);
                try {
                    runne.join();
                    finished = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        executeThread.start();
    }

    public void shutdown(Long mills){
        long currentTime = System.currentTimeMillis();
        while(!finished){
            if ((System.currentTimeMillis()-currentTime)>=mills)
                System.out.println("任务超时需要结束");
        }
    }
}
