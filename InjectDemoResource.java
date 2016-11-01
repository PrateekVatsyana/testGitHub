package org.kaushik.javabrains.messanger.resources;
	
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("/injectdemo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InjectDemoResource {
	@GET
	@Path("annotations")
    public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
    										@HeaderParam("authSessionId") String header,
    										@CookieParam("name") String cookie){
		
		
		return "Matrix Param :" +matrixParam + "Header is :"  + header + "Cookie is :" + cookie;
		
	}
	
	
	@GET
	@Path("context")
    public String getContextAnntation(@Context UriInfo uriInfo,@Context HttpHeaders headers){
			
 	String path = 	uriInfo.getAbsolutePath().toString();
 	String reqtURI = uriInfo.getRequestUri().toString();
 	String headerCookie =headers.getCookies().toString();
 	return "Path is :"+path+"\n header cookies :"+headerCookie;
	}
	
}
