package org.example.test;

import org.example.entities.Employee;
import org.example.entities.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        //set multiple emp
        Employee e1=new Employee();
        e1.seteId(1);
        e1.seteName("Ramesh");

        Employee e2=new Employee();
        e2.seteId(2);
        e2.seteName("shyam");

        Employee e3=new Employee();
        e3.seteId(3);
        e3.seteName("Ganesh");

        //set multiple project
        Project p1=new Project();
        p1.setpId(101);
        p1.setpName("Library Management Project");

        Project p2=new Project();
        p2.setpId(102);
        p2.setpName("Chatbot");

        Project p3=new Project();
        p3.setpId(103);
        p3.setpName("Ecom Website");

        //add all employee into list
        List<Employee> list_Emp=new ArrayList<>();
        list_Emp.add(e1);
        list_Emp.add(e2);
        list_Emp.add(e3);

        //add all project into List
        List<Project> list=new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        e1.setProjectList(list);

        p2.setEmployeeList(list_Emp);

        //session
        Session session=factory.openSession();
        Transaction tx =session.beginTransaction();

        //save
        session.save(e1);
        session.save(e2);
        session.save(e3);

        session.save(p1);
        session.save(p2);
        session.save(p3);



        tx.commit();
        factory.close();
        session.close();
    }
}
