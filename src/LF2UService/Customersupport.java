package LF2UService;

import DataGeneration.Customerdetails;
import DataGeneration.place_order;

public interface Customersupport {

	public String createaccount(Customerdetails h);

	public boolean update(String s, Customerdetails d);

	public String getcustomer(String s);

	public String createorder(String s, place_order p);

	public String Showorder(String s);

	public String cancel(String s, String s1);

	public String getorderdetails(String s, String s1);
	
}
