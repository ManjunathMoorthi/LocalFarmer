package LF2UService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import DataGeneration.catalogmange;
import Service.Managerscope;

@Path("/managers")

public class Manager {
	
	Managersupport use=new Managerscope();
	public StringBuilder ExtractString(InputStream incomingData)
	{
		StringBuilder jsonInString = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				jsonInString.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		return jsonInString;
	}
	
	
	@Path("/catalog")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response catalog()
	{
		String out;
		out=use.getcatlist();
		if(out.equals("[]"))
		{
			return Response.status(Response.Status.NOT_FOUND).entity("Catalog is empty" ).build();
		}
		else
		{
			return Response.status(200).entity(out).build();
		}
		
	}
	
	@Path("/catalog")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createcat(InputStream incomingData)
	{
		String out;
		StringBuilder out1=ExtractString(incomingData);
		catalogmange use1;
		//mapping the value
		Gson f = new Gson();
		use1=f.fromJson(out1.toString(), catalogmange.class);
		out=use.addcat(use1);
		if(out=="[]")
		{
			return Response.status(Response.Status.NOT_FOUND).entity("productnot added invalid data").build();
		}
		
	return Response.status(201).entity(out).build();
	}
	
	@Path("/catalog/{gcpid}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Updatecat(InputStream incomingData,@PathParam("gcpid")String s, @Context UriInfo i) throws JsonParseException, JsonMappingException, IOException
	{
		
		StringBuilder b;
		b=ExtractString(incomingData);
		boolean a;
		catalogmange d;
		Gson f = new Gson();

			d=f.fromJson(b.toString(),catalogmange.class);
			a = use.update(s,d);
		
		if(a==false)
		{
			 return Response.status(Response.Status.NOT_FOUND).entity("product not found for ID: " + s).build();
		}
		else
		{
			UriBuilder builder = i.getAbsolutePathBuilder();
		       builder.path(s);
			return Response.created(builder.build()).build();
		}
		
		
		
	}
	
	@Path("/accounts")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response account()
	{
	
		String out;
		out=use.getmlist();
		return Response.status(200).entity(out).build();
		
	}
	@Path("/accounts/{mid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response accountwid(@PathParam("mid")int s)
	{
		String out;
		out=use.getmanager(s);
		if(out.equals("[]"))
		{
			return Response.status(Response.Status.NOT_FOUND).entity("manager account not found for ID: " + s).build();
		}
		else
		{
			return Response.status(200).entity(out).build();
		}
	}	
	
	@Path("/reports")
	@	GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getreportlist()
	
	{
		String out;
		out=use.getreplist();
		return Response.status(200).entity(out).build();
		
	}
	@Path("/reports/{mrid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getreportlistda(@PathParam("mrid")int s1,@QueryParam("start_date") String st1,@QueryParam("end_date") String st2)
	
	{
		String out;
		
		if(s1==1 || s1==2)
		{
			out= use.getreportt1(s1,st1,st2);
		}
		else if(s1==3|| s1==4||s1==5)
		{
			out=use.getreportt2(s1,st1,st2);
		}
		else
		{
			return Response.status(Response.Status.NOT_FOUND).entity("invalid mrid"+s1).build();
		}
			
		return Response.status(200).entity(out).build();
	}

	
}
