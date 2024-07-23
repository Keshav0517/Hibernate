package org.example.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "stud_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //generate values in sequence
    @Column(name = "ADDRESS_ID")
    private int addressId;
    @Column(name = "STREET",length = 50)
    private String street;
    @Column(name = "CITY",length = 25)
    private String city;
    @Column(name = "ADDED_DATE")
    @Temporal(TemporalType.DATE)                //it specify the format of Date
    private Date addedDate;
    private boolean isOpen;
    @Transient                                 //field x is not added inside table
    private double x;

    @Lob
    private byte[] image;

    public Address(int addressId,String street,String city,Date addedDate,boolean isOpen,double x,byte[] image){
        super();
        this.addressId=addressId;
        this.street=street;
        this.city=city;
        this.addedDate=addedDate;
        this.isOpen=isOpen;
        this.x=x;
        this.image=image;
    }

    public Address(){
        super();
    }

    public int getAddressId(){
        return addressId;
    }

    public void setAddressId(int addressId){
        this.addressId=addressId;
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

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", addedDate=" + addedDate +
                ", isOpen=" + isOpen +
                ", x=" + x +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
