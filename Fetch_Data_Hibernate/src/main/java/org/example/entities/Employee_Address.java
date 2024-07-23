package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "emp_address")
public class Employee_Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    private int flatNo;
    private String street;
    private String city;

    public Employee_Address(int addressId,int flatNo, String street, String city) {
        super();
        this.addressId=addressId;
        this.flatNo = flatNo;
        this.street = street;
        this.city = city;
    }

    public Employee_Address(){
        super();
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(int flatNo) {
        this.flatNo = flatNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee_Address{" +
                "addressId=" + addressId +
                ", flatNo=" + flatNo +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
