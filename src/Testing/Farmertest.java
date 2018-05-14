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
import dataList.Delivery;

public class Farmertest {
	Customerser s;
	deliverystatus d;
	Farmservice f,f1;
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
		f1=new Farmservice();
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
	public void testgetreportlist() {
		String g=f.getreportlist();
		boolean a1= Pattern.compile(Pattern.quote("701"), Pattern.CASE_INSENSITIVE).matcher(g).find();
        assertEquals(a1,true);
	}
	
	@Test
	public void testCreate() {
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
		int i=f.getfarmlist().size();
		assertEquals(i,1);
		
	}

	@Test
	public void testUpdate() {
		Farmerdata fr=new Farmerdata();
		Farm_info fi=new Farm_info();
		Personal_info pl=new Personal_info();
		
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
		
		Farmerdata fr1=new Farmerdata();
		Farm_info fi1=new Farm_info();
		Personal_info pl1=new Personal_info();
		String[] fp1={"60010", "60011"};
		fi1.setName("boss 2");
		fi1.setPhone("8089842432");
		fi1.setWeb("bhasheyam@gmail.com");
		fi1.setAddress("napervile");
		pl1.setName("bhasheyam");
		pl1.setPhone("873982738");
		pl1.setEmail("bhasheyam@gmai.com");
		fr1.setDelivers_to(fp1);
		fr1.setFarm_info(fi1);
		fr1.setPersonal_info(pl1);
		
		
		f.update("1", fr1);
		int i=f.getfarmlist().size();
		assertEquals(i,1);
		
	}

	@Test
	public void testGetfarm() {
		Farmerdata fr=new Farmerdata();
		Farm_info fi=new Farm_info();
		Personal_info pl=new Personal_info();
		
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
		
		String g=f.getfarm("1");
		 boolean a1= Pattern.compile(Pattern.quote("boss"), Pattern.CASE_INSENSITIVE).matcher(g).find();
	        assertEquals(a1,true);
	}

	@Test
	public void testZip() {
		Farmerdata fr=new Farmerdata();
		Farm_info fi=new Farm_info();
		Personal_info pl=new Personal_info();
		
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
		String g=f.zip("60010");
		 boolean a1= Pattern.compile(Pattern.quote("boss"), Pattern.CASE_INSENSITIVE).matcher(g).find();
	        assertEquals(a1,true);
	}

	@Test
	public void testProductslist() {
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
		f.createprod("1", pr);
		String g=f.productslist("1");
		boolean a1= Pattern.compile(Pattern.quote("20161110"), Pattern.CASE_INSENSITIVE).matcher(g).find();
        assertEquals(a1,true);
		
		
	}

	@Test
	public void testCreateprod() {
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
		String g=f.createprod("1", pr);
		 boolean a1= Pattern.compile(Pattern.quote(""), Pattern.CASE_INSENSITIVE).matcher(g).find();
	        assertEquals(a1,true);
		
	}

	@Test
	public void testUpdateproductinfo() {
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
		Productdetails pr1= new Productdetails();
		pr.setStart_date("20161110");
		pr.setEnd_date("");
		pr.setNote("sucess");
		pr.setPrice(0.10d);
		pr.setGcpid("1");
		pr.setImage("");
		pr.setPrice(5.0);
		pr.setProduct_unit("lb");
		String g=f.createprod("1", pr);
		boolean a=f.updateproductinfo("1", "1", pr1);
		assertEquals(a,true);
	}

	@Test
	public void testGetproductdetails() {
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
		Productdetails pr1= new Productdetails();
		pr.setStart_date("20161110");
		pr.setEnd_date("");
		pr.setNote("sucess");
		pr.setPrice(0.10d);
		pr.setGcpid("1");
		pr.setImage("");
		pr.setPrice(5.0);
		pr.setProduct_unit("lb");
		f.createprod("1", pr);
		String g=f.getproductdetails("1", "1");
		boolean a1= Pattern.compile(Pattern.quote("sucess"), Pattern.CASE_INSENSITIVE).matcher(g).find();
        assertEquals(a1,true);
		
		
	}

	@Test
	public void testGetreportlist() {

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
		f.createprod("1", pr);
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
		String g=f.getreport("1", 702);
		boolean a1= Pattern.compile(Pattern.quote("702"), Pattern.CASE_INSENSITIVE).matcher(g).find();
        assertEquals(a1,true);
	}

	@Test
	public void testGetreportlist1() {

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
		String g=f.getreport("1", 703);
		boolean a1= Pattern.compile(Pattern.quote("0"), Pattern.CASE_INSENSITIVE).matcher(g).find();
        assertEquals(a1,true);
	}
	@Test
	public void testreporttype703()
	{
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
		String g=f.getreport1("1", 703,"20161110","20161121");
		boolean a1= Pattern.compile(Pattern.quote("0"), Pattern.CASE_INSENSITIVE).matcher(g).find();
        assertEquals(a1,true);
		
	}
	@Test
	public void testGetreportlist2() {

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
		d.Delivery("1");
		String g=f.getreport1("1", 704, "20161110", "20161125");
		 boolean a1= Pattern.compile(Pattern.quote("1"), Pattern.CASE_INSENSITIVE).matcher(g).find();
	        assertEquals(a1,true);
		
		
	}
	
	@Test
	public void testDeliverycharge() {
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
		Delivery dn=new Delivery();
		dn.setcharge(5.0);
		boolean a=f.deliverycharge("1", dn);
		assertEquals(a,true);
		
	}

	@Test
	public void testGetdeliverycharges() {
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
		Delivery dn=new Delivery();
		dn.setcharge(5.0);
		f.deliverycharge("1", dn);
		String g=f.getdeliverycharges("1");
		 boolean a1= Pattern.compile(Pattern.quote("5.0"), Pattern.CASE_INSENSITIVE).matcher(g).find();
	        assertEquals(a1,true);
		
	}

}
