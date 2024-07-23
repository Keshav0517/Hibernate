package org.example.test;

import org.example.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args){

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

        //used to save data inside table & insert data inside table
        Session session=factory.openSession();

        Transaction tx=session.beginTransaction();          //start session

        session.save(st);                    //insert data
        tx.commit();   //commit data physically

        session.close();                     //close session

    }
}
