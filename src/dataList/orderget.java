	package dataList;

import DataGeneration.corders;

public class orderget {
	private String cid;
	private String oid;
	private corders collection;
	
	public void set(String s)
	{
		this.cid=s;
	}
	public String getcid()
	{
		return this.cid;
	}
	public corders getorders()
	{
		return this.collection;
	}
	public void setorders(corders o)
	{
		this.collection=o;
	}
	public void setoid(String s)
	{
		this.oid=s;
	}
	public String getoid()
	{
		return this.oid;
	}

}
