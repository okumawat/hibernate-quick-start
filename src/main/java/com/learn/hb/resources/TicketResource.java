package com.learn.hb.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learn.hb.entity.Ticket;
import com.learn.hb.util.HibernateUtil;

@Path("/ticket")
public class TicketResource {

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("/{id}")
	public Response getTicket(@PathParam("id") int id) {
		Session session = null;
		Ticket ticket = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			ticket = session.get(Ticket.class, id);
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("Session closed.");
			}
		}
		return Response.status(200).entity(ticket).build();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response createTicket(Ticket ticket) {
		Session session = null;
		Transaction txn = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			txn = session.beginTransaction();
			session.save(ticket);
			txn.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			if(txn!=null) {
				txn.rollback();
			}
			System.out.println(e.getMessage());
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session closed.");
			}
		}
		return Response.status(201).entity(ticket).build();
	}
	
	@DELETE
	@Path("/{ticketId}")
	public Response deleteTicket(@PathParam("ticketId") int id) {
		
		Session session = null;
		Transaction txn = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			txn = session.beginTransaction();
			Ticket ticket = session.get(Ticket.class, id);
			session.delete(ticket);
			txn.commit();
		} catch (HibernateException e) {
			if(txn!=null) {
				txn.rollback();
			}
			System.out.println(e.getMessage());
		}finally {
			if(session!=null) {
				session.close();
				System.out.println("session closed.");
			}
		}
		return Response.status(204).build();
		
	}
	
	
}




