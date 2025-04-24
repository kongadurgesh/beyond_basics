package entity;

public abstract class Phone {
    String mobileName;

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    abstract double price();
}
