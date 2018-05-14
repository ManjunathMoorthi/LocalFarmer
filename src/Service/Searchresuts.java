package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DataGeneration.Customerdetails;
import DataGeneration.Farmerdata;
import DataGeneration.OrderReport;
import LF2UService.searchsupport;

public class Searchresuts implements searchsupport {
	
	String Result;
	List<Farmerdata> col=new ArrayList<Farmerdata>();
	 List<Customerdetails> col1=new ArrayList<Customerdetails>();
	 List<OrderReport> col2=new ArrayList<OrderReport>();

	public String Searchf(String key)
	{
		List<Farmerdata> temp=new ArrayList<Farmerdata>();
		String use;
		boolean a1=false;
		col=Farmservice.getfarmlist();
		for(Farmerdata f2:col)
		{
			Gson f1=new GsonBuilder().setPrettyPrinting().create();
	         use=f1.toJson(f2);
	         a1= Pattern.compile(Pattern.quote(key), Pattern.CASE_INSENSITIVE).matcher(use).find();
	         if(a1=true)
	         {
	        	 temp.add(f2);
	         }
		}
		
		
		 Gson f=new GsonBuilder().setPrettyPrinting().create();
         use=f.toJson(temp);
         return use;
		
	}
	public String Searchc(String key)
	{
		List<Customerdetails> temp=new ArrayList<Customerdetails>();
		String use;
		 
		col1=Customerser.getcustomer();
		for(Customerdetails f2:col1)
		{
			Gson f1=new GsonBuilder().setPrettyPrinting().create();
	         use=f1.toJson(f2);
	         boolean a1= Pattern.compile(Pattern.quote(key), Pattern.CASE_INSENSITIVE).matcher(use).find();
	         if(a1=true)
	         {
	        	 temp.add(f2);
	         }
		}
	         Gson f=new GsonBuilder().setPrettyPrinting().create();
	         use=f.toJson(temp);
	         return use;
		
	}
	public String Searcho(String key)
	{
		List<OrderReport> temp=new ArrayList<OrderReport>();	
		String use;
		
		col2=Customerser.getorderlist();
		for(OrderReport f2:col2)
		{
			Gson f1=new GsonBuilder().setPrettyPrinting().create();
	         use=f1.toJson(f2);
	         boolean a1= Pattern.compile(Pattern.quote(key), Pattern.CASE_INSENSITIVE).matcher(use).find();
	         if(a1=true)
	         {
	        	 temp.add(f2);
	         }
		}
	         Gson f=new GsonBuilder().setPrettyPrinting().create();
	         use=f.toJson(temp);
	         return use;
		
	}
	@Override
	public String search(String s, String s2) {
		String Result;
		if(s.equals("farm"))
		{
			Result=Searchf(s2);
		}
		else if (s.equals("customer"))
		{
			Result=Searchc(s2);
		}
		else if(s.equals("order"))
		{
			Result=Searcho(s2);
		}
		else
		{
			Result="wrong";
		}
		return Result;
	}
	
}
