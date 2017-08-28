/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author durgesh
 */
public class Main_Hiber {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
       /* Test firstTest = new Test();
        // firstTest.setTestId(new Random().nextInt(421));
        firstTest.setTestName("Java Test");
        Question q1 = new Question();
        q1.setQuestion("Size of the char data type in Java??");
        // q1.setQuestionId(new Random().nextInt(421));

        Option qo1 = new Option();
        qo1.setOption("option1");
        Option qo2 = new Option();
        qo2.setOption("option1");
        Option qo3 = new Option();
        qo3.setOption("option1");
        List<Option> ll=new ArrayList<>();
        ll.add(qo1);
        ll.add(qo2);
        ll.add(qo3);
        q1.setOptions(ll);
        

        Question q2 = new Question();
        //q2.setQuestionId(new Random().nextInt(421));
        q2.setQuestion("Size of the char data type in Java??");
        q2.setOptions(ll);
        List<Question> qlist = new ArrayList<Question>();
        qlist.add(q1);
        qlist.add(q2);
        firstTest.setQuestions(qlist);
*/
        Session s = factory.openSession();
        Transaction t = s.beginTransaction();
        for(int i=1;i<=100;i++)
        {
            Question q=new Question();
            q.setQuestion("Question "+i +")Is java pure Object Oriented Programming Language? ");
            Options o1=new Options();
            o1.setO("Yess "+i);
             Options o2=new Options();
            o2.setO("No "+i);
             Options o3=new Options();
            o3.setO("99 % ,Object oriented "+i);
             Options o4=new Options();
            o4.setO("None of these "+i);
            Set<Options> oo=new HashSet<Options>();
            oo.add(o1);
            oo.add(o2);
            oo.add(o3);
            oo.add(o4);
            q.setOptions(oo);
            
            Answer a=new Answer();
            a.setAnswer(o1.getO());
            q.setAns(a);
            s.save(q);
            
            
            
            
            
            
        }
        t.commit();
        s.close();

    }
}
