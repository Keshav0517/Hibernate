package org.example.test;


import org.example.entities.Certificate;
import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        //set student1 data
        Student student1=new Student();
        student1.setId(101);
        student1.setName("Nilesh");
        student1.setAddress("Indore");


        //set Certificate1 Data
        Certificate certificate1=new Certificate();
        certificate1.setCourse("Java");
        certificate1.setDuration("Oct 1- Mar 31st");

        student1.setCertificate(certificate1);

        //set student2 data
        Student student2=new Student();
        student2.setId(105);
        student2.setName("Rahul");
        student2.setAddress("Pune");

        //set certificate2 data
        Certificate certificate2=new Certificate();
        certificate2.setCourse("Hibernate");
        certificate2.setDuration("2 months");

        student2.setCertificate(certificate2);




        Session session=factory.openSession();
        Transaction tx =session.beginTransaction();

        session.save(student1);
        session.save(student2);


        tx.commit();
        session.close();
        factory.close();

    }
}
