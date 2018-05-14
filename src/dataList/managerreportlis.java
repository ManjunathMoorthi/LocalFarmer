package dataList;
import java.util.ArrayList;
import java.util.List;

import DataGeneration.*;

public class managerreportlis {
	
	private int[] mrid={1,2,3,4,5};
    private String[] name={ "Orders placed today","Orders placed yesterday","Revenue for previous month","Revenue yesterday","Revenue yesterday by zip code"};
    private int[] mid={1,2,3};
    private String[] name1={"Manager1","Manager2","Manager3"};
	private String[] create_date={"20160317","20161015","20160515"};
	private String[] phone={"9853259834","8327589237","3908590352"};
	private String[] email={"boss@maanager.com","manager@manager.com","manager2@manager.com"};
    
    managerreport mr =new managerreport();
    managerreport mr1 =new managerreport();
    managerreport mr2 =new managerreport();
    managerreport mr3 =new managerreport();
    managerreport mr4 =new managerreport();
    
    Manageraccount ma=new Manageraccount();
    Manageraccount ma1=new Manageraccount();
    Manageraccount ma2=new Manageraccount();
    List<managerreport> m=new ArrayList<managerreport>();
    List<Manageraccount> m1=new ArrayList<Manageraccount>();
   
    
    
   
    public void setreplist()
    {
    	
    	mr.setMrid(mrid[0]);
    	mr.setName(name[0]);
    	mr1.setMrid(mrid[1]);
    	mr1.setName(name[1]);
    	mr2.setMrid(mrid[2]);
    	mr2.setName(name[2]);
    	mr3.setMrid(mrid[3]);
    	mr3.setName(name[3]);
    	mr4.setMrid(mrid[4]);
    	mr4.setName(name[4]);
    	m.add(mr);
    	m.add(mr1);
    	m.add(mr2);
    	m.add(mr3);
    	m.add(mr4);
    }
    public void setaccount()
    {
    	ma.setmid(mid[0]);
    	ma.setname(name1[0]);
    	ma.setcreate(create_date[0]);
    	ma.setemail(email[0]);
    	ma.setphone(phone[0]);
    	ma1.setmid(mid[1]);
    	ma1.setname(name1[1]);
    	ma1.setcreate(create_date[1]);
    	ma1.setemail(email[1]);
    	ma1.setphone(phone[1]);
    	ma2.setmid(mid[2]);
    	ma2.setname(name1[2]);
    	ma2.setcreate(create_date[2]);
    	ma2.setemail(email[2]);
    	ma2.setphone(phone[2]);
    	
    	m1.add(ma);
    	m1.add(ma1);
    	m1.add(ma2);
    	
    }
    public List<managerreport> getrepmana()
    
    {
    return this.m;	
    }
    public List<Manageraccount> getaccount()
    {
    	return this.m1;
    }
    
}
