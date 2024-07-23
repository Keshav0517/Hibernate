package org.example.test;

import org.example.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Pagination {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        Session session=factory.openSession();
        Transaction tx =session.beginTransaction();

        String query="from Product";
        Query q =session.createQuery(query);

        //implementation of Pagination
        q.setFirstResult(4);      //starting row

        q.setMaxResults(6);      //no of rows


        List<Product> list=q.list();
        for (Product p:list){
            System.out.println(p.getId()+":"+p.getName()+":"+p.getPrice());
        }

        tx.commit();
        session.close();
        factory.close();
    }
}
