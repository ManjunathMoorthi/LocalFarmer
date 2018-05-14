package DataGeneration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Idgen {
	static int counter =0;
	static int counterc=0;
	static int countero=0;
	static int counterp=0;
	static int countercp=0;
	
	public static String gcpid()
	{
		countercp=countercp+1;
		
		return ""+countercp;
	}
	public static String fid()
	{
		counter=counter+1;
		return counter+"";
	}
	public static String cid()
	{
		counterc=counterc+1;
		return counterc+"";
	}
	public static String oid()
	{
		countero=countero+1;
		return countero+"";
	}
	public static String pid()
	{
		counterp=counterp+1;
		return counterp+"";
	}
	public  static String getcurrentdate()
	{
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date dateobj = new Date();
		return df.format(dateobj);
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
		counter =0;
		counterc=0;
		 countero=0;
	 counterp=0;
	countercp=0;
		
		
	}
	
	
}
