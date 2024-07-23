package org.example.NativeQuery;

import org.example.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;

public class Sql_Query {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        Session session=factory.openSession();
        Transaction tx =session.beginTransaction();

        String query="Select * from Product";
        NativeQuery nq =session.createSQLQuery(query);

        List<Object[]> list=nq.list();

        for (Object[] product:list){
            System.out.println(Arrays.toString(product));
        }

        tx.commit();
        session.close();
        factory.close();
    }
}
