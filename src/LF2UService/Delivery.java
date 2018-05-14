package LF2UService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import Service.deliverystatus;
@Path("/delivery")
public class Delivery {
	Deliversupport use=new deliverystatus();
	
boolean a;

	@Path("/{oid}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response Deliverysta(@PathParam("oid")String s,@Context UriInfo i)
	{ 
		String a;
		
		a=use.Delivery(s);
		if(a=="no")	
		{
			 return Response.status(Response.Status.NOT_FOUND).entity("Order not found for ID: " + s).build();
		}
		else if(a=="can")
		{
			return Response.status(Response.Status.NOT_FOUND).entity("Order is already cancelled ID: " + s).build();
		}
		else if(a=="[]")
		{
			return Response.status(Response.Status.NOT_FOUND).entity("invalid oder details").build();
		}
		else{

		UriBuilder builder = i.getAbsolutePathBuilder();
	       builder.path(s);
		return Response.created(builder.build()).build();
		}
		}
		
		
}
