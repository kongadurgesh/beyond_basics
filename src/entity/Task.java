package entity;

public class Task {
    private int counter;

    public int incrementCounter() {
        return counter++;
    }

    public Task(int counter) {
        this.counter = counter;
    }
}
