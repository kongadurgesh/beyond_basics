package entity;

public class DiamondCustomer extends Customer {

    @Override
    public void calculatAmount(int amount) {
        int discountedAmount = (amount - 100) > 0 ? amount - 100 : amount;

        System.out.println("The Total Amount: " + discountedAmount);
    }

}
