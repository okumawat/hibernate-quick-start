package com.learn.hb;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learn.hb.entity.Application;
import com.learn.hb.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Application app = new Application(4, "Hibernate", "Hibernate quick start");
        Transaction txn = null;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        txn = session.beginTransaction();
        
        session.save(app);
        txn.commit();
    }
}
