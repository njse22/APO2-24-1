package util;

public class RunnableClass implements Runnable{

    private int time;

    private String message;

    public RunnableClass(int time, String message) {
        this.time = time;
        this.message = message;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(20000 - (time*1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(message);


    }
}
