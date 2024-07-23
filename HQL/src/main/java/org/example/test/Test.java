package org.example.test;

import org.example.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        Product product1=new Product();
        product1.setId(101);
        product1.setName("Milk");
        product1.setPrice(23);

        Product product2=new Product();
        product2.setId(102);
        product2.setName("Good Day");
        product2.setPrice(10);

        Product product3=new Product();
        product3.setId(103);
        product3.setName("Dairy Milk");
        product3.setPrice(20);


        Session session= factory.openSession();
        Transaction tx =session.beginTransaction();

        session.save(product1);
        session.save(product2);
        session.save(product3);

        //HQL
        String query="from Product where price>:x";
        Query q =session.createQuery(query);
        q.setParameter("x",10.0);    //projection


        //single data [uniqueResult()]
        //multiple data (list)
        List<Product> list=q.list();
        for(Product p:list){
            System.out.println(p.getId()+":"+p.getName()+":"+p.getPrice());
        }


        tx.commit();
        session.close();
        factory.close();
    }
}
