package org.example.test;

import org.example.entities.Employee_Address;
import org.example.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws IOException {

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        //set data of Employee
        Employee employee=new Employee();
        employee.setName("Prof.Shyam");
        employee.setDepartment("AI");
        employee.setJoining(new Date());

        //Read Image
        FileInputStream fis=new FileInputStream("src/main/java/pic2.jpg");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        employee.setImage(data);

        //set data of Emp Address
        Employee_Address ad=new Employee_Address();
        ad.setFlatNo(200);
        ad.setStreet("Street 2");
        ad.setCity("Indore");

        //Save()
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();

        session.save(employee);
        session.save(ad);

        tx.commit();
        System.out.println("Done....");
        session.close();
        factory.close();


    }
}
