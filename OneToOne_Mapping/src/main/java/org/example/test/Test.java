package org.example.test;

import org.example.entities.Answers;
import org.example.entities.Questions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        //set data for Questions and Answers table
        Questions q1=new Questions();
        q1.setQuestionId(101);
        q1.setQuestion("What is Java?");


        Answers a1=new Answers();
        a1.setAnswerId(343);
        a1.setAnswer("Java is PL");

        q1.setAns(a1);
        a1.setQuestions(q1);



        //Set data for Questions and Answers table
        Questions q2=new Questions();
        q2.setQuestionId(114);
        q2.setQuestion("What is Collections FW");

        Answers a2=new Answers();
        a2.setAnswerId(344);
        a2.setAnswer("Used to Store Group of Objects");

        q2.setAns(a2);                //ques->ans
        a2.setQuestions(q2);         //ans->ques


        //Session
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();

        session.save(q1);
        session.save(q2);

        session.save(a1);
        session.save(a2);

        tx.commit();

        //Fetching.....
        Questions ques=(Questions) session.get(Questions.class,101);
        System.out.println(ques.getQuestion());
        System.out.println(ques.getAns().getAnswer());


        session.close();
        factory.close();

    }
}
