package LF2UService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Service.Searchresuts;
@Path("search")
public class Search {
	
	searchsupport use=new Searchresuts();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getdetails(@QueryParam("topic")String topic,@QueryParam("key")String key)
	{
		String out;
		if(topic==null||key==null)
		{
			return Response.status(Response.Status.NOT_FOUND).entity("key or value is null").build();
			
		}
		out=use.search(topic,key);
		
		if(out.equals("wrong"))
		{
			return Response.status(Response.Status.NOT_FOUND).entity("invalid  topic"+topic).build();
		}
		
		if(out.equals("[]"))
		{
			return Response.status(Response.Status.NOT_FOUND).entity("no result for the search").build();
		}
		else
		{
			return Response.status(200).entity(out).build();
		}
	
		
	}

	
	

}
