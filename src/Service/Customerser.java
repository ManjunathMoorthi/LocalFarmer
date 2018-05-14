package Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DataGeneration.Customerdetails;
import DataGeneration.Farm_info;
import DataGeneration.Farmerdata;

import DataGeneration.OrderReport;
import DataGeneration.Order_detail;
import DataGeneration.Order_details;
import DataGeneration.Productdetails;
import DataGeneration.catalogmange;
import DataGeneration.corders;
import DataGeneration.place_order;
import DataGeneration.supportdc;
import LF2UService.Customersupport;
import dataList.Delivery;
import dataList.cid;
import dataList.oid;
import dataList.orderget;

public class Customerser implements Customersupport {
public static List<Customerdetails> col=new ArrayList<Customerdetails>();
public static List<place_order> col1=new ArrayList<place_order>();
public static List<corders> col2=new ArrayList<corders>();
public static List<orderget> col3=new ArrayList<orderget>();
public static List<OrderReport> col5=new ArrayList<OrderReport>();
 List<corders> col4=new ArrayList<corders>();

 public static List<place_order> getplaceorder()
 {
 	return col1;
 }
 public static List<Customerdetails> getcustomer()
 {
 	return col;
 }
 public static List<corders> getcorder()
{
	return col2;
}
public static List<orderget> getorderget()
{
	return col3;
}
public static void setcorder(List<corders> s)
{
	col2=s;
}
public static void setorderget(List<orderget> s)
{
	col3=s;
}
public static List<OrderReport> getorderlist() {
	
	return col5;
}
public static void setorderlist(List<OrderReport> s)
{
	col5=s;
}

	@Override
	public String createaccount(Customerdetails h) {
		String out;
		col.add(h);
		cid g=new cid();
		String p=h.getcid();
		g.set(p);
		Gson f1 = new GsonBuilder().setPrettyPrinting().create();
		 out=f1.toJson(g);
		 return out;	
		 
	}
	@Override
	public boolean update(String s, Customerdetails d) {
		
		boolean a=false;
		try{
		for(Customerdetails h:col)
		{ 
			String check=h.getcid();
			if(check.equals(s))
			{
				int i=col.indexOf(h);				
				d.setcid(check);
				col.set(i,d);
				a=true;
			}
		}
		
		return a;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public   String getcurrentdate()
	{
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date dateobj = new Date();
		return df.format(dateobj);
	}
	@Override
	public String getcustomer(String s) {
		 
		String out;
		
		for(Customerdetails h:col)
		{ 
			String check=h.getcid();
			if(check.equals(s))
			{
				Gson f1 = new GsonBuilder().setPrettyPrinting().create();
				 out=f1.toJson(h);
				 return out;
			}
		}
		
		 return "[]";	
	}
	public boolean verifycustomer(String s)
	{
		boolean a=false;
		String c1;
		for(Customerdetails c:col)
		{c1=c.getcid();
		if(c1.equals(s))
		{
			a=true;
		}
			
		}
	return a;	
	}
	@Override
	public String createorder(String s, place_order p) {
	      String out,c,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12;
	      String[] zip=null;
	      boolean b1=false,b2=true;
	      double d1,d2,d3,d4=0.0d,d5=0.0d,d6;
	      Farm_info far=new Farm_info();
	      List<Farmerdata> temp=new ArrayList<Farmerdata>();
	      List<Productdetails> temp2=new ArrayList<Productdetails>();
	      List<Delivery> temp3=new ArrayList<Delivery>();
	      List<catalogmange> temp4=new ArrayList<catalogmange>();
	      List<Order_details> orderlist = new ArrayList<Order_details>();
	      b2=verifycustomer(s);
	      if(b2==false)
	      {
	    	  return "[]";
	      }
	      
	      Order_detail[] order;
	     
	      OrderReport rep=new OrderReport();
	      
	      
	      
	      
	      
	      col1.add(p);
	  	String t=p.getFid();
      	String t1=p.getoid();
	    //checking the zip code
      	temp=Farmservice.getfarmlist();
	      c9=p.getFid();
	      try {
      	  for(Farmerdata d:temp)
      	  {
      		  c10=d.getfid();
      		  if(c9.equals(c10))
      		  {
      			 zip=d.getDelivers_to(); 
      		  }
      		  
      	  }
      	  for(Customerdetails h:col)
      	  {
      		  c11=h.getcid();
      		  if(c11.equals(s))
      		  {
      			  c12=h.getZip();
      			for(String zips:zip)
      			{
      				if(zips.equals(c12))
      				{
      					b1=true;
      				}
      			}
            	  if(b1==false)
            	  {
            		  return "no farm on this zip";
            	  }
      		  }
      	  }
      	//update view order
	      
      	  
      	//mapping th order details
	      	corders o=new corders();
	      
	      	o.setFid(t);
	      	o.setOid(t1);
	      	col2.add(o);
	      	//customer and order mapping
	    	orderget k=new orderget();
	      	k.set(s);
	      	k.setoid(t1);
	      	k.setorders(o);
	      	col3.add(k);
	//updating the order report
	      	 rep.setOid(t1);
	      	 rep.setOrder_date(o.getOrder_date());
	      	 rep.setPlanned_delivery_date(o.getPlanned_delivery_date());
	      	 rep.setActual_delivery_date(o.getActual_delivery_date());
	      	 rep.setStatus(o.getStatus());
	      	 
	      	temp2=Farmservice.getproductlist();
	      	temp3=Farmservice.getdeliverylist();
	      	temp4=Managerscope.getlist();
	      order=p.getOrder_detail();
	      	 for(Farmerdata fa:temp)
	      	 {
	      		 c=fa.getfid();
	      		 if(c.equals(t))
	      		 {
	      			 far=fa.getFarm_info();
	      		 }
	      	 }
	      	
	      	 far.setfid(t);
	      	 rep.setFarm_info(far);
	      	 rep.setDelivery_note(p.getDelivery_note());
	      	 for(Delivery dp:temp3)
	      	 {
	      		 c2=dp.getid();
	      		 if(c2.equals(t))
	      		 {
	      			 d5=dp.getcharges();
	      			 rep.setDelivery_charge(d5);
	      		 }
	      	 }
	      	 for(Order_detail h:order)
	      	 {
	      		Order_details repo=new Order_details();
	      		 c4=h.getFspid();
	      		 d1=h.getamount();
	      	 
	      	 for(Productdetails gg:temp2)
	      	 {
	      		 c3=gg.getfspid();
	      		 if(c3.equals(c4))
	      		 {
	      			 repo.setFspid(c3);
	      			 d2=gg.getPrice();
	      			 d3=d2*d1;
	      			 repo.setLine_item_total(d3);
	      			 d4=d4+d3;
	      			 c5=gg.getPrice()+"per "+gg.getProduct_unit();
	      			 repo.setPrice(c5);
	      			 c6=d1+" "+gg.getProduct_unit();
	      			 repo.setOrder_size(c6);
	      			 c8=gg.getGcpid();
	      			 for(catalogmange lk:temp4)
	      			 {
	      				 c7=lk.getGcpid();
	      				 if(c8.equals(c7))
	      				 {
	      					 repo.setName(lk.getName());
	      					 	 
	      					 
	      				 }
	      			 }
	      		 } 
	      		
	      	 }
	      	 orderlist.add(repo);
	      	 }
	      	 rep.setOrder_detail(orderlist);
	      	 rep.setProducts_total(d4);
	      	 d6=d4+d5;
	      	 rep.setOrder_total(d6);
			 
	      }
	      catch(Exception e)
	      {
	    	  return "[]";
	      }
		//sending json class
		      	oid o1=new oid();
		      	o1.set(t1);
	
	      	//adding to the master
	      	col5.add(rep);
	//getClass.converting json
		Gson f1 = new GsonBuilder().setPrettyPrinting().create();
		 out=f1.toJson(o1);
		 return out;
		 
		
	      }
	

@Override
public String Showorder(String s) {
	String out;
	String c;
	
	try{
		for(orderget p:col3){
	
	
		c=p.getcid();
		if(c.equals(s))
		{
			col4.add(p.getorders());
			
		}
	}
	Gson f1 = new GsonBuilder().setPrettyPrinting().create();
	 out=f1.toJson(col4);
}
		 catch(Exception e)
		 {
			 return "[]";
	 }
	 return out;
}
@Override
public String cancel(String s, String s1) {
	String out;
	String g,ck,ck1,ck2,c1;
	try{
		
	
	for(corders e1:col2)
	{
		g=e1.getOid();
		if(g.equals(s1))
		{
			ck=getcurrentdate();
			ck1=e1.getOrder_date();
			ck2=e1.getStatus();
			if(ck2.equals("open"))
			{
			if(ck.equals(ck1))
			{
				e1.setStatus("cancelled");
			supportdc d=new supportdc();
			d.Support("cancelled");
			Gson f1 = new GsonBuilder().setPrettyPrinting().create();
			 out=f1.toJson(d);
			 for(OrderReport fl:col5)
			 { c1=fl.getOid();
			 if(c1.equals(s1))
			 {
				 fl.setStatus("cancelled");
			 }
				 
			 }
			 return out;
			
			}
			else 
			{
				return "no";
			}
			}
			else
			{
				return "can";
			}
		}
	}
	}
        catch(Exception e)
	{
	return"[]";
	}

       return"[]";
}	 
	

@Override
public String getorderdetails(String s, String s1) {
	String out,c,c1;
	boolean a=false;
	OrderReport use=new OrderReport();
	
	for(orderget k:col3)
	{
		c=k.getcid();
		c1=k.getoid();
		if(c.equals(s)&&c1.equals(s1))
		{
			a=true;
		}
		else
		{
			return "invalid order and customer id";
		}
	}
	if(a==true)
	{
	for(OrderReport o:col5)
	{
		c=o.getOid();
		if(c.equals(s1))
		{
			use=o;
		}
	}
	 
	Gson f1 = new GsonBuilder().setPrettyPrinting().create();
	 out=f1.toJson(use);
	 return out;
	}
	return"[]";
}
public void reset()
{
	col.clear();
	col1.clear();
	col2.clear();
	col3.clear();
	col5.clear();
}

}

	

	

	

