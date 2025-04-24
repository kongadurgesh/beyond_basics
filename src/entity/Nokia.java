package entity;

@ChangeDetail(authorName = "Sam", methodName = "price")
public class Nokia extends Phone {

    @Override
    double price() {
        return 15000;
    }

    double calc() {
        return 10000;
    }
}
