package org.example.test;


import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Second_Level_Cache {
    public static void main(String[] args) {

        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session1=factory.openSession();
        //first
        Student s1=session1.get(Student.class,125);
        System.out.println(s1);

        session1.close();

        System.out.println("Working Something...");

        Session session2=factory.openSession();
        //second
        Student s2=session2.get(Student.class,125);
        System.out.println(s2);

        session2.close();


        factory.close();

    }

}
