package model;

@FunctionalInterface
public interface Shape {
    public void draw();

    public default Double area(Integer radius) {
        return 3.14 * radius;
    }

    public default void fill(String color) {
        System.out.println("Inside default fill with" + color);
    }

    public static void clean() {
        System.out.println("Inside static method");
    }
}
