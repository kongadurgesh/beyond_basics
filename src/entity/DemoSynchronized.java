package entity;

public class DemoSynchronized {
    private int balance = 2000;

    public void deposit(int amount) {
        System.out.println("Initial: " + balance);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        balance += amount;
        System.out.println("Final: " + balance);
    }
}
