package org.example.test;

import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class First_Level_Cache {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        Session session=factory.openSession();


        //First Level Caching
        Student s1=session.get(Student.class,125);
        System.out.println(s1);

        System.out.println("Working Something....");

        Student s2=session.get(Student.class,125);
        System.out.println(s2);


        //Check s1 is present into cache memory or not
        boolean check=session.contains(s2);
        System.out.println("Cache Memory:"+check);



        session.close();
        factory.close();
    }
}
