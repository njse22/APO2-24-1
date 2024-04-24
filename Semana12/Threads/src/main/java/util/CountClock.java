package util;

public class CountClock  extends Thread {

    private long count;

    public CountClock(long count){
        this.count = count;
    }

    public void run(){
        for (int i = 0; i < count; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("time ..." + i);
        }
    }
}
