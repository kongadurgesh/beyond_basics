package entity;

public class DemoThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread created");
    }
}
