package Testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DataGeneration.Customerdetails;
import DataGeneration.Farm_info;
import DataGeneration.Farmerdata;
import DataGeneration.Idgen;
import DataGeneration.Order_detail;
import DataGeneration.Personal_info;
import DataGeneration.Productdetails;
import DataGeneration.catalogmange;
import DataGeneration.place_order;
import Service.Customerser;
import Service.Farmservice;
import Service.Managerscope;
import Service.Searchresuts;
import Service.deliverystatus;

public class delivery {
	Customerser s;
	deliverystatus d;
	Farmservice f;
	Managerscope m;
	Searchresuts sr;
	Customerdetails c;
	Idgen i;
	@Before
	public void setup()
	{
		s=new Customerser();
		d=new deliverystatus();
		f=new Farmservice();
		 m=new Managerscope();
		 sr=new Searchresuts();
		 c=new Customerdetails();
		 i=new Idgen();
			
		 
	}
	@After
	public void finish()
	{
		s.reset();
		f.reset();
		m.reset();
		i.reset();
		
		
	}

	@Test
	public void testDelivery() {
		Farmerdata fr=new Farmerdata();
		Farm_info fi=new Farm_info();
		Personal_info pl=new Personal_info();
		
		
		
		catalogmange ca=new catalogmange();
		ca.setName("potato");
		m.addcat(ca);
		String[] fp={"60010", "60011"};
		fi.setName("boss");
		fi.setPhone("8089842432");
		fi.setWeb("bhasheyam@gmail.com");
		fi.setAddress("napervile");
		pl.setName("bhasheyam");
		pl.setPhone("873982738");
		pl.setEmail("bhasheyam@gmai.com");
		fr.setDelivers_to(fp);
		fr.setFarm_info(fi);
		fr.setPersonal_info(pl);
		f.create(fr);
		Productdetails pr= new Productdetails();
		pr.setStart_date("20161110");
		pr.setEnd_date("");
		pr.setNote("sucess");
		pr.setPrice(0.10d);
		pr.setGcpid("1");
		pr.setImage("");
		pr.setProduct_unit("lb");
		c.setName("sriram");
		c.setPhone("9003203629");
		c.setStreet("woodie drive");
		c.setEmail("sriram@gmail.com");
		c.setZip("60010");
		s.createaccount(c);
		place_order p=new place_order();
		Order_detail o=new Order_detail();
		Order_detail[] oa=new Order_detail[1];
		p.setDelivery_note("successu");
		p.setFid("1");
		o.setamount(2);
		o.setFspid("1");
		oa[0]=o;
		p.setOrder_detail(oa);
		s.createorder("1", p);
	String g=d.Delivery("1");
	assertEquals(g,"done");
	
		
	}

}
