package Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import DataGeneration.By_farmer;
import DataGeneration.Farmerdata;
import DataGeneration.Manageraccount;
import DataGeneration.OrderReport;
import DataGeneration.catalogmange;
import DataGeneration.managereport12;
import DataGeneration.managerreport;
import DataGeneration.managerreport45;
import LF2UService.Managersupport;
import dataList.gcpid;
import dataList.managerreportlis;

public class Managerscope implements Managersupport {
	
	managerreportlis m=new managerreportlis();
	
	public static List<catalogmange> col=new ArrayList<catalogmange>();
	public static List<catalogmange> getlist()
	{
		return col;
	}
	//manager report list
	public  String getreplist()
	{
		
		List<managerreport> mh=new ArrayList<managerreport>();
		
		m.setreplist();
		mh=m.getrepmana();
		Gson f = new GsonBuilder().setPrettyPrinting().create();
		String out=f.toJson(mh);
		return out;
		
	}
//manager account list
	@Override
	public String getmlist() {
	String out;
	List<Manageraccount> man=new ArrayList<Manageraccount>();
	
	m.setaccount();
	man=m.getaccount();
	Gson f = new GsonBuilder().setPrettyPrinting().create();
	 out=f.toJson(man);
	return out;
	}
//manager with an id
	@Override
	public String getmanager(int mid) {
		String out;
		List<Manageraccount> man=new ArrayList<Manageraccount>();
		List<Manageraccount> man1=new ArrayList<Manageraccount>();
		
		m.setaccount();
		man=m.getaccount();
		
		
	for(Manageraccount mn:man)
	{
		if(mn.getmid()==mid)
		{
			man1.add(mn);
			
		}
		
	}
	
	Gson f = new GsonBuilder().setPrettyPrinting().create();
	 out=f.toJson(man1);
	return out;
	}
	public  String getyest()
	{
		
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date dateobj = new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(dateobj);
	    cal.add(Calendar.DATE, -1); 
	    dateobj=cal.getTime();
		return df.format(dateobj);
	}
	public  String getlast()
	{
		
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date dateobj = new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(dateobj);
	    cal.add(Calendar.MONTH, -1); 
	    dateobj=cal.getTime();
		return df.format(dateobj);
	}
	public  String getcurrentdate()
	{
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date dateobj = new Date();
		return df.format(dateobj);
	}
//manager report type 1 and 2
	@Override
	public String getreportt1(int s1,String s2, String s3) {
		String out,c1;
		String key;
		int t=0,t1=0,t2=0,t3=0;
		
		managereport12 rep1=new managereport12();
		List<OrderReport> temp1=new ArrayList<OrderReport>();
		temp1=Customerser.getorderlist();
	try{	
	  if(s1==1)
	  {
		  key=getcurrentdate();
		  rep1.setMrid(s1);
		  rep1.setName("Orders placed today");
	  }
	  else
	  {
		  key=getyest();
		  rep1.setName("Orders placed yesterday");
		  rep1.setMrid(s1);
	  }
		  if(s2==null||s3==null)
		  {
			 
			  for(OrderReport k:temp1)
			  {
				  String dat=k.getOrder_date();
				 
				  if(key.equals(dat))
				  {
					  
					  t=t+1;
					  
						c1=k.getStatus();
						
					  if(c1.equals("open"))
					  {
						  t1=t1+1;
					  }
					  else if(c1.equals("Delivered"))
					  {
						  t2=t2+1;
					  }
					  else
					  {
						  t3=t3+1;
					  }
					  
				  }
			  }
			  rep1.setOrders_placed(t);
			  rep1.setOrders_delivered(t2);
			  rep1.setOrders_open(t1);
			  rep1.setOrders_cancelled(t3);
		  }
	
		  else
		  {
			  Date enddate=new Date();
				Date startdate=new Date();
				DateFormat df1 = new SimpleDateFormat("yyyyMMdd");
				try {
					 startdate=df1.parse(s2);
					 enddate=df1.parse(s3);
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
				
				Calendar start = Calendar.getInstance();
				start.setTime(startdate);
				Calendar end = Calendar.getInstance();
				end.setTime(enddate);
				for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1),date = start.getTime())
				{
					String k1=df1.format(date);
					 for(OrderReport k:temp1)
					  {
						  if(k1.equals(k.getOrder_date()))
						  {
							  t=t+1;
							  
								c1=k.getStatus();
								
							  if(c1.equals("open"))
							  {
								  t1=t1+1;
							  }
							  else if(c1.equals("Delivered"))
							  {
								  t2=t2+1;
							  }
							  else
							  {
								  t3=t3+1;
							  }
							  
						  }
					  }
				}
					  rep1.setOrders_placed(t);
					  rep1.setOrders_delivered(t2);
					  rep1.setOrders_open(t1);
					  rep1.setOrders_cancelled(t3);	
		  }
	}
	catch(Exception e)
	{
		return "[]";
	}
	  
		Gson f = new GsonBuilder().setPrettyPrinting().create();
		 out=f.toJson(rep1);
		return out;
	}
	
	//manager report type 4 and 3
	@Override
	public String getreportt2(int s1, String s2, String s3) {
		String out,c,c2,st,ed;
		List<Farmerdata> temp=new ArrayList<Farmerdata>();
		 List<OrderReport> temp1=new ArrayList<OrderReport>();
		 temp=Farmservice.getfarmlist();
		 temp1=Customerser.getorderlist();
		List<By_farmer> far=new ArrayList<By_farmer>(); 
		int t4=0,t5=0,t6=0,t7=0;
		double d5=0.0d,d6=0.0d,d7=0.0d,d8 = 0,d9=0.0d;
		 managerreport45 rep1=new managerreport45();
		 try{
		 if(s2==null||s3==null)
		 {
			 if(s1==3)
			 {
				 st=getlast();
			  ed=getnextday();
			  Date enddate=new Date();
				Date startdate=new Date();
				DateFormat df1 = new SimpleDateFormat("yyyyMMdd");
				try {
					 startdate=df1.parse(st);
					 enddate=df1.parse(ed);
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
				
				Calendar start = Calendar.getInstance();
				start.setTime(startdate);
				Calendar end = Calendar.getInstance();
				end.setTime(enddate);
				for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1),date = start.getTime())
				{ String c8=df1.format(date);
				int t = 0,t1 = 0,t2=0,t3=0;
				double d=0.0,d1=0.0,d2=0.0,d3=0.0,d4=0.0;
				
					for(Farmerdata f:temp)
					{
						By_farmer farc=new By_farmer();
						c=f.getfid();
						c2=f.getFarm_info().getName();
						for(OrderReport r:temp1)
						{
							
							r.getOrder_date();
							String c7=r.getFarm_info().getfid();
							
							if(c8.equals(r.getOrder_date())&&c7.equals(c))
							{
								rep1.setName("came");
								farc.setName(c2);
								farc.setFid(c);
								t3=t3+1;
								if(r.getStatus().equals("open"))
								{
									t=t+1;
								}
								else if(r.getStatus().equals("cancelled"))
								{
									t1=t1+1;
								}
								else
								{
									t2=t2+1;
								}
								d=d+r.getOrder_total();
								d1=d1+r.getDelivery_charge();
								d2=d2+r.getProducts_total();
								d3=d*0.03;
								d4=d-d3;
								
	
							}
						}
						farc.setOrders_placed(t3);
						farc.setOrders_delivered(t2);
						farc.setOrders_open(t);
						farc.setOrders_cancelled(t1);
						farc.setTotal_revenue(t);
						farc.setDelivery_revenue(d1);
						farc.setProducts_revenue(d2);
						farc.setLftu_fees(d3);
						farc.setPayable_to_farm(d4);
						if(farc.getProducts_revenue()==0.0d)	
						{
							continue;
						}
						else
						{
							far.add(farc);
						}
					}
					t4=t4+t3;
					t7=t7+t;
					t5=t5+t1;
					t6=t6+t2;
					d5=d5+d;
					d6=d6+d1;
					d7=d7+d2;
					d8=d8+d3;
					d9=d9+d4;
				}
			     rep1.setMrid(s1);
			     rep1.setName("Revenue for previous month");
				 rep1.setBy_farmer(far);
				 rep1.setOrders_placed(t4);
				 rep1.setOrders_delivered(t6);
				 rep1.setOrders_open(t7);
				 rep1.setOrders_cancelled(t5);
				 rep1.setTotal_revenue(d5);
				 rep1.setTotal_delivery_revenue(d6);
				 rep1.setTotal_products_revenue(d7);
				 rep1.setTotal_lftu_fees(d8);
				 rep1.setTotal_payable_to_farms(d9);
				 Gson f = new GsonBuilder().setPrettyPrinting().create();
				 out=f.toJson(rep1);
				return out;
				 
			 }
			 else if(s1==4||s1==5)
			 {
				 String key=getyest();
					
						for(Farmerdata f:temp)
						{

							int t = 0,t1 = 0,t2=0,t3=0;
							double d=0.0,d1=0.0,d2=0.0,d3=0.0,d4=0.0;
							By_farmer farc=new By_farmer();
							c=f.getfid();
							c2=f.getFarm_info().getName();
							for(OrderReport r:temp1)
							{
								
								r.getOrder_date();
								String c7=r.getFarm_info().getfid();
								
								if(key.equals(r.getOrder_date())&&c7.equals(c))
								{
									
									farc.setName(c2);
									farc.setFid(c);
									t3=t3+1;
									if(r.getStatus().equals("open"))
									{
										t=t+1;
									}
									else if(r.getStatus().equals("cancelled"))
									{
										t1=t1+1;
									}
									else
									{
										t2=t2+1;
									}
									d=d+r.getOrder_total();
									d1=d1+r.getDelivery_charge();
									d2=d2+r.getProducts_total();
									d3=d*0.03;
									d4=d-d3;
									
		
								}
							}
							farc.setOrders_placed(t3);
							farc.setOrders_delivered(t2);
							farc.setOrders_open(t);
							farc.setOrders_cancelled(t1);
							farc.setTotal_revenue(t);
							farc.setDelivery_revenue(d1);
							farc.setProducts_revenue(d2);
							farc.setLftu_fees(d3);
							farc.setPayable_to_farm(d4);
							if(farc.getProducts_revenue()==0.0d)	
							{
								continue;
							}
							else
							{
								far.add(farc);
							}
							t4=t4+t3;
							t7=t7+t;
							t5=t5+t1;
							t6=t6+t2;
							d5=d5+d;
							d6=d6+d1;
							d7=d7+d2;
							d8=d8+d3;
							d9=d9+d4;
						}
							
				     rep1.setMrid(s1);
				     rep1.setName("Revenue yesterday");
					 rep1.setBy_farmer(far);
					 rep1.setOrders_placed(t4);
					 rep1.setOrders_delivered(t6);
					 rep1.setOrders_open(t7);
					 rep1.setOrders_cancelled(t5);
					 rep1.setTotal_revenue(d5);
					 rep1.setTotal_delivery_revenue(d6);
					 rep1.setTotal_products_revenue(d7);
					 rep1.setTotal_lftu_fees(d8);
					 rep1.setTotal_payable_to_farms(d9);
					 Gson f = new GsonBuilder().setPrettyPrinting().create();
					 out=f.toJson(rep1);
					return out;
					 
			 }
		 }
		 else
		 {
			 
			  Date enddate=new Date();
				Date startdate=new Date();
				DateFormat df1 = new SimpleDateFormat("yyyyMMdd");
				try {
					 startdate=df1.parse(s2);
					 enddate=df1.parse(s3);
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
				
				Calendar start = Calendar.getInstance();
				start.setTime(startdate);
				Calendar end = Calendar.getInstance();
				end.setTime(enddate);
				for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1),date = start.getTime())
				{ String c8=df1.format(date);
				int t = 0,t1 = 0,t2=0,t3=0;
				double d=0.0,d1=0.0,d2=0.0,d3=0.0,d4=0.0;
				
					for(Farmerdata f:temp)
					{
						By_farmer farc=new By_farmer();
						c=f.getfid();
						c2=f.getFarm_info().getName();
						for(OrderReport r:temp1)
						{
							
							r.getOrder_date();
							String c7=r.getFarm_info().getfid();
							
							if(c8.equals(r.getOrder_date())&&c7.equals(c))
							{
								rep1.setName("came");
								farc.setName(c2);
								farc.setFid(c);
								t3=t3+1;
								if(r.getStatus().equals("open"))
								{
									t=t+1;
								}
								else if(r.getStatus().equals("cancelled"))
								{
									t1=t1+1;
								}
								else
								{
									t2=t2+1;
								}
								d=d+r.getOrder_total();
								d1=d1+r.getDelivery_charge();
								d2=d2+r.getProducts_total();
								d3=d*0.03;
								d4=d-d3;
								
	
							}
						}
						farc.setOrders_placed(t3);
						farc.setOrders_delivered(t2);
						farc.setOrders_open(t);
						farc.setOrders_cancelled(t1);
						farc.setTotal_revenue(t);
						farc.setDelivery_revenue(d1);
						farc.setProducts_revenue(d2);
						farc.setLftu_fees(d3);
						farc.setPayable_to_farm(d4);
						if(farc.getProducts_revenue()==0.0d)	
						{
							continue;
						}
						else
						{
							far.add(farc);
						}
					}
					t4=t4+t3;
					t7=t7+t;
					t5=t5+t1;
					t6=t6+t2;
					d5=d5+d; 
					d6=d6+d1;
					d7=d7+d2;
					d8=d8+d3;
					d9=d9+d4;
				}
			     rep1.setMrid(s1);
			     rep1.setName("Revenue for the range "+s2+" "+s3);
				 rep1.setBy_farmer(far);
				 rep1.setOrders_placed(t4);
				 rep1.setOrders_delivered(t6);
				 rep1.setOrders_open(t7);
				 rep1.setOrders_cancelled(t5);
				 rep1.setTotal_revenue(d5);
				 rep1.setTotal_delivery_revenue(d6);
				 rep1.setTotal_products_revenue(d7);
				 rep1.setTotal_lftu_fees(d8);
				 rep1.setTotal_payable_to_farms(d9);
		 
				 Gson f = new GsonBuilder().setPrettyPrinting().create();
				 out=f.toJson(rep1);
				return out;
		
		 }
		 }
			catch(Exception e)
			{
				return "[]";
			}
		 return "[]";
	}
	
//catalog add
	@Override
	public String addcat(catalogmange use1) {
	
	String out;
	try
	{
	//adding to a list to have concolidated one.
	col.add(use1);
	
	gcpid g=new gcpid();
	//to print the json
	//sending json out
	String p=use1.getGcpid();
	g.set(p);
	Gson f1 = new GsonBuilder().setPrettyPrinting().create();
	 out=f1.toJson(g);
	 return out;	
	}
	catch(Exception e)
	{
		return "[]";
	}
	}
//catalog list
	@Override
	public String getcatlist() {
		String out;
		Gson f1 = new GsonBuilder().setPrettyPrinting().create();
		 out=f1.toJson(col);
		 return out;
	}
	//catalog search
	@Override
	public boolean update(String s, catalogmange d)  {
		boolean b1=false;
		try {
		for(catalogmange h:col)
		{ 
			String check=h.getGcpid();
			if(check.equals(s))
			{
				
				int i=col.indexOf(h);
				
				
				d.setgcpid(check);
				col.set(i,d);
				b1=true;
			}
		}
		
		return b1;
	}
		catch(Exception e)
		{
			return false;
		}
	}
	public static  String getnextday()
	{
		
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date dateobj = new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(dateobj);
	    cal.add(Calendar.DATE, 1); 
	    dateobj=cal.getTime();
		return df.format(dateobj);
	}
	public void reset() {
		col.clear();
		
		
	}
	
	
	
	

}
