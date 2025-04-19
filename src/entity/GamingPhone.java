package entity;

import java.util.ArrayList;

public class GamingPhone extends BudgetPhone {

    @Override
    public void megaDiscount() {
        System.out.println("25% Offer applied");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addPhones() {
        ArrayList list = new ArrayList<>();
        list.add("Lenovo KS");
    }
}
