package Testing;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

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

public class search {
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
	public void testSearchf() {
		Farmerdata fr1=new Farmerdata();
		Farm_info fi1=new Farm_info();
		Personal_info pl1=new Personal_info();
		String[] fp={"60010", "60011"};
		fi1.setName("boss 2");
		fi1.setPhone("8089842432");
		fi1.setWeb("bhasheyam@gmail.com");
		fi1.setAddress("napervile");
		pl1.setName("bhasheyam");
		pl1.setPhone("873982738");
		pl1.setEmail("bhasheyam@gmai.com");
		fr1.setDelivers_to(fp);
		fr1.setFarm_info(fi1);
		fr1.setPersonal_info(pl1);
		f.create(fr1);
		String g=sr.Searchf("boss");
		 boolean a1= Pattern.compile(Pattern.quote("boss"), Pattern.CASE_INSENSITIVE).matcher(g).find();
	        assertEquals(a1,true);
		
	}

	@Test
	public void testSearchc() {

		c.setName("sriram");
		c.setPhone("9003203629");
		c.setStreet("woodie drive");
		c.setEmail("sriram@gmail.com");
		c.setZip("60010");
		s.createaccount(c);
		String g=sr.Searchc("sri");
        boolean a1= Pattern.compile(Pattern.quote("sriram"), Pattern.CASE_INSENSITIVE).matcher(g).find();
        assertEquals(a1,true);
	}

	@Test
	public void testSearcho() {
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
		String g=sr.Searcho("boss");
        boolean a1= Pattern.compile(Pattern.quote("successu"), Pattern.CASE_INSENSITIVE).matcher(g).find();
        assertEquals(a1,true);
	}

	
}
