package entity;

import java.io.Serializable;

public class Address implements Serializable {
    private String city;
    private int pinCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public Address(String city, int pinCode) {
        super();
        this.city = city;
        this.pinCode = pinCode;
    }
}
