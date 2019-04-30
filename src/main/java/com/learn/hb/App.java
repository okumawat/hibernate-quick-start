package com.learn.hb;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learn.hb.entity.Application;
import com.learn.hb.entity.Ticket;
import com.learn.hb.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Application app = new Application(5, "GitHub", "SCM version tool");
    	Ticket ticket = new Ticket(14, "SN", "orm1", 6, "In Progress");
    	//create(ticket);
    	tickets();
    	//delete(13);
    	//update(12,"Closed");
    }
    public static void create(Ticket ticket) {
    	Session session = null;
    	try {
    		session = HibernateUtil.getSessionFactory().openSession();
    		Transaction txn = session.beginTransaction();
    		session.save(ticket);
    		txn.commit();
    		
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		if(session!=null)
    			session.close();
    	}
    }
    
    public static void update(int id, String status) {
    	Session session = null;
    	try {
    		session = HibernateUtil.getSessionFactory().openSession();
    		Transaction txn = session.beginTransaction();
    		Ticket ticket=session.get(Ticket.class, id);
    		
    		ticket.setStatus(status);
    		session.update(ticket);
    		txn.commit();
    		
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		if(session!=null)
    			session.close();
    	}
    }
    
    public static void delete(int id) {
    	Session session = null;
    	try {
    		session = HibernateUtil.getSessionFactory().openSession();
    		Transaction txn = session.beginTransaction();
    		Ticket ticket=session.get(Ticket.class, id);
    		
    		session.delete(ticket);
    		txn.commit();
    		
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		if(session!=null)
    			session.close();
    	}
    }
    
    public static void tickets() {
    	Session session = null;
    	try {
    		session = HibernateUtil.getSessionFactory().openSession();
    		Transaction txn = session.beginTransaction();
    		List<Ticket> list = session.createQuery("from Ticket").list();
    		
    		for(Ticket ticket :list) {
    			System.out.println(ticket.toString());
    		}
    		
    		txn.commit();
    		
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}finally {
    		if(session!=null)
    			session.close();
    	}
    }
}
