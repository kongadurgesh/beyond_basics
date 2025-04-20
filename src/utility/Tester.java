package utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
}
