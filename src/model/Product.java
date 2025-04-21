package model;

import java.util.Optional;

public class Product {
    private Integer id;
    private String name;
    private Double rating;
    private Integer price;
    private String seller;

    public Product(Integer id, String name, Double rating, Integer price, String seller) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.price = price;
        this.seller = seller;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Product(Integer id, String name, Double rating, Integer price) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", rating=" + rating + ", price=" + price + "]";
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Optional<String> getSellerOptional() {
        return Optional.ofNullable(seller);
    }

}
