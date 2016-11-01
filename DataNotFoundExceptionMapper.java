package org.kaushik.javabrains.messanger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{



	@Override
	public Response toResponse(DataNotFoundException arg0) {
		// TODO Auto-generated method stub
		return Response.status(Status.NOT_FOUND).build();
	}

}
