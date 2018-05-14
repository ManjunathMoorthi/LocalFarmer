package dataList;

public class Delivery {
	private String fid;
	private double delivery_charge;
	public void setcharge(double d)
	{
		this.delivery_charge=d;
	}
public void setfid(String s)
{
	this.fid=s;
}
public double getcharges()
{
	return this.delivery_charge;
}
public String getid()
{
	return this.fid;
}
}
