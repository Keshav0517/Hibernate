package org.example.test;

import org.example.entities.Answers;
import org.example.entities.Questions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        //Set data for Questions Table
        Questions q1=new Questions();
        q1.setQuestionId(105);
        q1.setQuestion("What is Spring FW");

        Answers a1=new Answers();
        a1.setAnswerId(305);
        a1.setAnswer("Spring is Java FW");
        a1.setQuestion(q1);


        Answers a2=new Answers();
        a2.setAnswerId(306);
        a2.setAnswer("Spring FW is used to simplify development of JavaEE");
        a1.setQuestion(q1);


        List<Answers> list=new ArrayList<>();
        list.add(a1);
        list.add(a2);


        q1.setAnswersList(list);

        //session
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();

        session.save(q1);
//        session.save(a1);
//        session.save(a2);

        tx.commit();

        //Normal Fetching
//        Questions questions=(Questions) session.get(Questions.class,105);
//        System.out.println(questions.getQuestion());
//
//        for (Answers answers:questions.getAnswersList()){
//            System.out.println(answers.getAnswer());
//        }

        //Lazy Loading
//        Questions questions=(Questions) session.get(Questions.class,105);
//        System.out.println(questions.getQuestion());
//        System.out.println(questions.getQuestionId());
//        System.out.println(questions.getAnswersList().size());   //get ans

        //Eager Loading-->add  @OneToMany(fetch=FetchType.EAGER)
        Questions questions=(Questions) session.get(Questions.class,105);
        System.out.println(questions.getQuestionId());
        System.out.println(questions.getQuestion());
        System.out.println(questions.getAnswersList().size());



        session.close();
        factory.close();
    }
}
