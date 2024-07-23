package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "stud_info")
public class Student {
    @Id
    private int id;
    private String name;
    private String address;

    private Certificate certificate;

    public Student(int id,String name,String address,Certificate certificate ){
        super();
        this.id=id;
        this.name=name;
        this.address=address;
        this.certificate=certificate;
    }

    public Student(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", certificate=" + certificate +
                '}';
    }
}
