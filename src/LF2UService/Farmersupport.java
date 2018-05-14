package LF2UService;

import DataGeneration.Farmerdata;
import DataGeneration.Productdetails;
import dataList.Delivery;

public interface Farmersupport {

	String create(Farmerdata f);

	boolean update(String fid, Farmerdata f);

	String getfarm(String fid);

	String zip(String zi);

	String productslist(String s);

	String createprod(String s, Productdetails prod);

	boolean updateproductinfo(String s, String s1, Productdetails pd);

	String getproductdetails(String s, String s1);

	String getreportlist();


	boolean deliverycharge(String s, Delivery d1);

	String getdeliverycharges(String s);

	String getreport(String s, int s1);

	String getreport1(String s, int s1, String st1, String st2);
	String getreport1(String s, int s1);

	
}
