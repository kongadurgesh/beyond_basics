package entity;

import java.util.List;

public class SafeVarArgsTester {
    @SafeVarargs
    public final void test(List<String>... products) {
        for (List<String> product : products) {
            System.out.println(product);
        }
    }
}
