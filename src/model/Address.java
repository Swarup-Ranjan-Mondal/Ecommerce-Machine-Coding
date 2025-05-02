package model;

public class Address {
    private final String streetAddress;
    private final String city;
    private final String pincode;

    public Address(String streetAddress, String city, String pincode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.pincode = pincode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getPincode() {
        return pincode;
    }
}
