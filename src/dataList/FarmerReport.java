package dataList;

import java.util.ArrayList;
import java.util.List;

import DataGeneration.Report;

public class FarmerReport {
	int[] id={701,702,703,704};
	String[] s={"Orders to deliver today", "Orders to deliver tomorrow","Revenue report","Orders delivery report" };
	
	List<Report> r=new ArrayList<Report>();
	Report r1=new Report();
	Report r2=new Report();
	Report r3=new Report();
	Report r4=new Report();
     public List<Report> getlist()
     {
    	 r1.setid(id[0]);
    	 r1.setname(s[0]);
    	 r2.setid(id[1]);
    	 r2.setname(s[1]);
    	 r3.setid(id[2]);
    	 r3.setname(s[2]);
    	 r4.setid(id[3]);
    	 r4.setname(s[3]);
    	 
    	 r.add(r1);
    	 r.add(r2);
    	 r.add(r3);
    	 r.add(r4);
    	 
    	 
    	 return r;
    	 
     }
      
 
	
	
	

}
