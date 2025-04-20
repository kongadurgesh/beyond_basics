package model;

public class IncrementThread implements Runnable {
    private static int counter = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            increment();
        }
    }

    public void increment() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

}
