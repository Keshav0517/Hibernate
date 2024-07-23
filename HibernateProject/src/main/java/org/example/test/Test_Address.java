package org.example.test;

import org.example.entities.Address;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class Test_Address {
    public static void main(String[] args) throws IOException {

        //For Configuration file-> SessionFactory factory=new Configuration().configure().buildSessionFactory();

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();


        //set student data
        Student st=new Student();
        st.setId(101);
        st.setName("Shubham");
        st.setCity("Indore");
        System.out.println(st);

        //Set address data
        Address ad=new Address();
        ad.setStreet("Street1");
        ad.setCity("Indore");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(120.2);

        //Read image
        FileInputStream fileInputStream=new FileInputStream("src/main/java/pic.png");
        byte[] data=new byte[fileInputStream.available()];
        fileInputStream.read(data);
        ad.setImage(data);



        //used to save data inside table & insert data inside table
        Session session=factory.openSession();

        Transaction tx=session.beginTransaction();          //start session

        session.save(st);                    //insert data
        session.save(ad);

        tx.commit();   //commit data physically
        System.out.println("Done...");
        session.close();                     //close session

    }
}
