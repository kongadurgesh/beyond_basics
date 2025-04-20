package model;

import java.util.Arrays;
import java.util.List;

public class ProductTester {
    public static void test() {
        List<String> productList = Arrays.asList("Frock", "Book", "Ball", "Pen");
        productList.sort((String product1, String product2) -> product1.compareTo(product2));
        for (String product : productList) {
            System.out.println(product);
        }
    }
}
