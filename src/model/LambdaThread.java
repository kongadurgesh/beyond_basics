package model;

public class LambdaThread {
    public static void testOld() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("without lambda");
            }
        });
        thread.start();
    }

    public static void testNew() {
        Thread thread = new Thread(() -> System.out.println("With Lambda"));
        thread.start();
    }

    public static void testMultiple() throws InterruptedException {
        IncrementThread thread = new IncrementThread();
        Thread thread_1 = new Thread(thread);
        Thread thread_2 = new Thread(thread);

        thread_1.start();
        thread_2.start();

        thread_1.join();
        thread_2.join();

        System.out.println(IncrementThread.getCounter());

    }
}
