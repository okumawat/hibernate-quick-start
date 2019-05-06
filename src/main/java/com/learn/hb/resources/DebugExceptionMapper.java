package com.learn.hb.resources;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DebugExceptionMapper implements ExceptionMapper<Exception>{

	@Override
	public Response toResponse(Exception exception) {
		// TODO Auto-generated method stub
		return Response.serverError().entity(exception.getMessage()).build();
	}
	
}
