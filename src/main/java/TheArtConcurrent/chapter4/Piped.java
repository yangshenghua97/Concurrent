package TheArtConcurrent.chapter4;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);
        Thread printThread = new Thread(new Print(in),"PrintThread");
        printThread.start();
        int receive = 0;
        while((receive = System.in.read())!=-1){
            out.write(receive);
        }
    }
    static class Print implements Runnable {
        private PipedReader in;
        public Print(PipedReader in){
            this.in = in;
        }

        @Override
        public void run() {
            int recetive = 0;
            try {
                while ((recetive = in.read()) != -1) {
                    System.out.println(recetive);
                }
            }catch (IOException ie){
            }
        }
    }
}
