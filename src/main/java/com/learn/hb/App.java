package com.learn.hb;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
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
    	App mainApp = new App();
        Application app = new Application(4, "Log4j1", "Logging framework1");
        mainApp.getApplications();
        
    }
    public void createApplication(Application app) {
    	Transaction txn = null;
    	Session session = null;
        try {
			session = HibernateUtil.getSessionFactory().openSession();
			txn = session.beginTransaction();
			
			session.save(app);
			txn.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
        
    }
    
    public void deleteApplication(int appId) {
    	Transaction txn = null;
        Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			txn = session.beginTransaction();
			
			Application app = (Application)session.get(Application.class, appId);
			session.delete(app);
			txn.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
        
    }
    
    public void getApplications() {
    	Session session = null;
    	try {
			session = HibernateUtil.getSessionFactory().openSession();
			Transaction txn = session.beginTransaction();
			
			String queryString = "FROM Application";
			List apps = session.createQuery(queryString).list();
			Iterator itr = apps.iterator();
			while(itr.hasNext()) {
				Application app = (Application)itr.next();
				System.out.println(app.toString());
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			session.close();
		}
    	
    }
    
}
