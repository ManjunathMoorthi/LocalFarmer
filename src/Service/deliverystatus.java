package Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DataGeneration.OrderReport;
import DataGeneration.corders;
import LF2UService.Deliversupport;
import dataList.orderget;

public class deliverystatus implements Deliversupport {
	public static List<corders> temp1=new ArrayList<corders>();
	public static List<orderget> temp2=new ArrayList<orderget>();
	public static List<OrderReport> temp3=new ArrayList<OrderReport>();
	public  String getcurrentdate()
	{
		DateFormat df = new SimpleDateFormat("yyyyMMdd ");
		Date dateobj = new Date();
		return df.format(dateobj);
	}
	String date=getcurrentdate();
	@Override
	public String Delivery(String id) {
		String a="no";
		
		temp1=Customerser.getcorder();
		temp2=Customerser.getorderget();
		temp3=Customerser.getorderlist();
		String s1,s2,s3,s4;
		//setting orderc status
		try{
			
		
		for(corders s:temp1)
		{ s1=s.getOid();
		if(s1.equals(id))
		{
			s3=s.getStatus();
			if(s3.equals("open"))
			{	
	
			s.setStatus("Delivered");
			s.setactual(date);
			for(orderget f:temp2)
			{
				s2=f.getoid();
						if(s2.equals(id))
						{
							f.setorders(s);
							a="done"
;						}
			}
			//setting in the master account order
			for(OrderReport d:temp3)
			{
				s4=d.getOid();
				if(s4.equals(id))
				{
					d.setStatus("Delivered");
					d.setActual_delivery_date(date);
				}
			}
			}
			else 
			{
				return "can";
			}
			}
		}
		Customerser.setcorder(temp1);
		Customerser.setorderget(temp2);
		Customerser.setorderlist(temp3);
		return a;
	}
		catch(Exception e)
		{
			return "[]";
		}
	}
	

}
