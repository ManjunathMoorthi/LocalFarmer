package dataList;

import DataGeneration.Productdetails;

public class Productlist {

	private String id;
	private Productdetails prod;
	private String pid;
	public void setid(String s)
	{
		this.id=s;
	}
	public void setpid(String s)
	{
		this.pid=s;
	}
	public void setprod(Productdetails s)
	{
		this.prod=s;
	}
	
	public String getid()
	{
		return this.id;
	}
	public String getpid()
	{
		return this.pid;
	}
	public Productdetails getprod()
	{
		return this.prod;
	}
}
