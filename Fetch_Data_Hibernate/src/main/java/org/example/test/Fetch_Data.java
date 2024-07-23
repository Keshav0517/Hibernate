package org.example.test;


import org.example.entities.Employee;
import org.example.entities.Employee_Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch_Data {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        Session session=factory.openSession();

        //get Employee Detail using id
        Employee employee=(Employee) session.get(Employee.class,1);
        System.out.println(employee);
//
//        Employee employee1=(Employee) session.get(Employee.class,1);
//        System.out.println(employee1);

        //get Address of Emp using ID
//        Employee_Address address=(Employee_Address) session.load(Employee_Address.class,2);
//        Employee_Address address1=(Employee_Address) session.load(Employee_Address.class,2);
//        System.out.println(address);
//        System.out.println(address1);

        session.close();
        factory.close();

    }
}
