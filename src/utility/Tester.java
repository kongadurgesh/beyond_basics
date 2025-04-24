package utility;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import entity.DemoSynchronized;
import entity.DemoThread;
import entity.Task;
import model.Product;
import model.Shape;

public class Tester {
    public void testShape() {
        Shape.clean();
    }

    public static void testProducts() {
        Product frock = new Product(1001, "Frock", 5.0, 100);
        Product watch = new Product(2001, "Watch", 4.9, 600);
        Product shirt = new Product(3001, "Shirt", 4.5, 500);
        Product violin = new Product(4001, "Violin", 3.5, 800);

        List<Product> products = Arrays.asList(frock, watch, shirt, violin);

        evaluate(products, product -> (product.getPrice() > 500));
    }

    private static void evaluate(List<Product> products, Predicate<Product> predicate) {
        for (Product product : products) {
            if (predicate.test(product)) {
                System.out.println(product.getName());
            }
        }
    }

    public static void testStreams() {
        Product frock = new Product(1001, "Frock", 5.0, 100, "Dell");
        Product watch = new Product(2001, "Watch", 4.9, 600, "HP");
        Product shirt = new Product(3001, "Shirt", 4.5, 500, "Dell");
        Product violin = new Product(4001, "Violin", 3.5, 800, "HP");

        List<Product> products = Arrays.asList(frock, watch, shirt, violin);

        products.stream().filter(product -> product.getPrice() > 400)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(product -> System.out.println(product.toString()));

        Optional<Product> productOptional = products.stream()
                .reduce((p1, p2) -> p1.getPrice() > p2.getPrice() ? p1 : p2);

        if (productOptional.isPresent()) {
            System.out.println(productOptional.get().toString());
        }

        List<List<Integer>> integers = Arrays.asList(Arrays.asList(21, 2, 3), Arrays.asList(4, 5, 6));

        integers.stream().flatMap(list -> list.stream()).collect(Collectors.toList())
                .forEach(element -> System.out.println(element));

        Map<String, List<Product>> productMap = products.stream()
                .collect(Collectors.groupingBy(product -> product.getSeller()));

        System.out.println(productMap);

        Stream.of("Mouse", "Charger", "Keyboard", "Charger", "Mouse").distinct().forEach(System.out::println);

        // count
        long count = Stream.of("Mouse", "Charger", "Keyboard", "Charger", "Mouse").distinct().count();
        System.out.println(count);
        // peek
        count = Stream.of("Mouse", "Charger", "Keyboard", "Charger", "Mouse").distinct().peek(System.out::println)
                .count();
        System.out.println(count);
    }

    public static void testStreams2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.stream().map(n -> n * n * n).forEach(number -> System.out.println(number));

        int sum = Stream.iterate(0, n -> n + 1).limit(50).reduce(0, Integer::sum);
        System.out.println(sum);

    }

    public static void testParallelStreams() {
        Stream<Integer> data1 = Stream.iterate(0, n -> n + 10).limit(10);

        Stream<Integer> parallelStream_1 = data1.parallel();

        parallelStream_1.forEach(System.out::println);

        Stream<Integer> data2 = Stream.iterate(5, n -> n + 10).limit(10);

        Stream<Integer> parallelStream_2 = data2.parallel();

        parallelStream_2.forEachOrdered(System.out::println);

        IntStream range_1 = IntStream.rangeClosed(1, 10);
        range_1.forEach(x -> {
            System.out.println("Thread: " + Thread.currentThread().getName() + ", value: " + x);
        });

        IntStream range_2 = IntStream.rangeClosed(1, 10);
        range_2.parallel().forEach(x -> {
            System.out.println("Thread: " + Thread.currentThread().getName() + ", value: " + x);
        });
    }

    public static void testStreamTime() {
        List<Integer> numbers = Stream.iterate(1, n -> n + 1).limit(1000).collect(Collectors.toList());

        // List<Integer> randomIntegers = new Random().ints(1,
        // 1001).limit(1000).boxed().collect(Collectors.toList());
        long startTime = System.currentTimeMillis();
        long countOfEvenIntegers = numbers.stream().filter(n -> n % 2 == 0).count();
        System.out.println(countOfEvenIntegers);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by normal stream: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        countOfEvenIntegers = numbers.parallelStream().filter(n -> n % 2 == 0).count();
        System.out.println(countOfEvenIntegers);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by parallel stream: " + (endTime - startTime));
    }

    public static void testChatGPT() {
        // Create a List of integers from 1 to 1000
        List<Integer> numbers = IntStream.rangeClosed(1, 1000).boxed().collect(Collectors.toList());

        // Measure time taken for sequential stream
        long startTime = System.currentTimeMillis();
        long evenCountSequential = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();
        long endTime = System.currentTimeMillis();
        long timeTakenSequential = endTime - startTime;

        // Print results for sequential stream
        System.out.println("Count of even numbers (sequential): " + evenCountSequential);
        System.out.println("Time taken (sequential): " + timeTakenSequential + " ms");

        // Measure time taken for parallel stream
        startTime = System.currentTimeMillis();
        long evenCountParallel = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .count();
        endTime = System.currentTimeMillis();
        long timeTakenParallel = endTime - startTime;

        // Print results for parallel stream
        System.out.println("Count of even numbers (parallel): " + evenCountParallel);
        System.out.println("Time taken (parallel): " + timeTakenParallel + " ms");

    }

    public static void testOptional() {
        String nullString = null;
        String data = "Hello";

        Optional<String> optionalString = Optional.empty();
        System.out.println(optionalString);

        Optional<String> optional_1 = Optional.of(data);
        System.out.println(optional_1);

        Optional<String> optional_2 = Optional.ofNullable(nullString);
        System.out.println(optional_2);
        // System.out.println(optional_2.get());
        if (optional_2.isPresent()) {
            System.out.println(optional_2.get());
        } else {
            System.out.println("Null Value");
        }
    }

    public static void testOptionalObject() {
        Product frock = new Product(1001, "Frock", 5.0, 100);

        if (frock.getSellerOptional().isPresent()) {
            System.out.println(frock.getSellerOptional().get());
        } else {
            System.out.println(frock.getSellerOptional());
        }
    }

    public static void testOptionalStream() {
        Product frock = new Product(1001, "Frock", 5.0, 100);
        Product watch = new Product(2001, "Watch", 4.9, 600);

        String seller_1 = Optional.ofNullable(frock).flatMap(product -> product.getSellerOptional()).orElse("default");

        System.out.println(seller_1);
        System.out.println(Optional.ofNullable(watch).map(Product::getPrice));

        System.out.println(Optional.ofNullable(frock)
                .map(Product::getPrice)
                .filter(product -> product >= 10)
                .filter(product -> product <= 1500)
                .isPresent());
    }

    public static void testThread() {
        DemoThread thread_1 = new DemoThread();
        thread_1.start();
    }

    public static void testRunnable() {
        Runnable runnable = () -> {
            System.out.println("Runnable Thread created");
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void testThreadSleep() {
        new Thread(() -> {
            System.out.println("Going to Sleep...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("After Sleep");
        }).start();
    }

    public static void testMultipleThreads() {
        Runnable runnable_1 = () -> {
            Thread thread_1 = Thread.currentThread();
            System.out.println(thread_1.getName() + " Started");

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(thread_1.getName() + " Ended");
        };
        Thread thread_1 = new Thread(runnable_1);

        Runnable runnable_2 = () -> {
            Thread thread_2 = Thread.currentThread();
            System.out.println(thread_2.getName() + " Started");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(thread_2.getName() + " Ended");
        };
        Thread thread_2 = new Thread(runnable_2);

        thread_1.start();
        try {
            thread_1.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        thread_2.start();
    }

    public static void testThreadGroup() {
        ThreadGroup threadGroup = new ThreadGroup("ThreadGroup");
        Runnable runnable = () -> {
            System.out.println("Thread created is: " + Thread.currentThread().getName());
        };
        Thread thread_1 = new Thread(threadGroup, runnable, "one");
        Thread thread_2 = new Thread(threadGroup, runnable, "two");
        Thread thread_3 = new Thread(threadGroup, runnable, "three");
        thread_1.start();
        thread_2.start();
        thread_3.start();

        System.out.println("Thread group name: " + threadGroup.getName());
        threadGroup.list();
    }

    public static void testExecutorService() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Runnable runnable_1 = () -> {
            System.out.println("Running Thread: " + Thread.currentThread().getName());
        };

        Runnable runnable_2 = () -> {
            System.out.println("Running Thread: " + Thread.currentThread().getName());
        };

        service.execute(runnable_1);
        service.shutdown();
        service.execute(runnable_2);
        service.shutdown();
    }

    public static void testExecutorServiceWithTime() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        System.out.println("Local Time: " + LocalTime.now());
        Runnable runnable_1 = () -> {
            System.out.println("Task 1: " + Thread.currentThread().getName() + ", Time: " + LocalTime.now());
        };
        Runnable runnable_2 = () -> {
            System.out.println("Task 2: " + Thread.currentThread().getName() + ", Time: " + LocalTime.now());
        };
        Runnable runnable_3 = () -> {
            System.out.println("Task 3: " + Thread.currentThread().getName() + ", Time: " + LocalTime.now());
        };

        executorService.schedule(runnable_1, 5, TimeUnit.SECONDS);
        executorService.schedule(runnable_2, 10, TimeUnit.SECONDS);
        executorService.schedule(runnable_3, 15, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    public static void testFixedExecutorService() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable runnable_1 = () -> {
            System.out.println("Task 1: " + Thread.currentThread().getName() + ", Time: " + LocalTime.now());
        };
        Runnable runnable_2 = () -> {
            System.out.println("Task 2: " + Thread.currentThread().getName() + ", Time: " + LocalTime.now());
        };
        Runnable runnable_3 = () -> {
            System.out.println("Task 3: " + Thread.currentThread().getName() + ", Time: " + LocalTime.now());
        };

        executorService.execute(runnable_1);
        executorService.execute(runnable_2);
        executorService.execute(runnable_3);

        executorService.shutdown();
    }

    public static void testThreadCounter() {
        Task task = new Task(5);
        Runnable runnable_1 = () -> {
            System.out.println(Thread.currentThread().getName() + " After Increment: " + task.incrementCounter());
        };
        Runnable runnable_2 = () -> {
            System.out.println(Thread.currentThread().getName() + " After Increment: " + task.incrementCounter());
        };
        Thread thread_1 = new Thread(runnable_1);
        Thread thread2 = new Thread(runnable_2);

        thread_1.start();
        thread2.start();
    }

    public static void testDemoSynchronized() {
        DemoSynchronized demoSynchronized = new DemoSynchronized();

        Runnable runnable_1 = () -> {
            synchronized (demoSynchronized) {
                demoSynchronized.deposit(1000);
            }
        };
        Runnable runnable_2 = () -> {
            synchronized (demoSynchronized) {
                demoSynchronized.deposit(1000);
            }
        };

        Thread thread_1 = new Thread(runnable_1);
        Thread thread_2 = new Thread(runnable_2);

        thread_1.start();
        thread_2.start();
    }
}