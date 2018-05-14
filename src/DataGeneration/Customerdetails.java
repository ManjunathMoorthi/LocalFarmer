package DataGeneration;

public class Customerdetails {
	
	
	
	private String cid;
	private String name;
	private String street;
    private String zip;
    private String phone;
    private String email;
    

    public String getZip ()
    {
        return zip;
    }
    public Customerdetails()
	{
		this.cid=Idgen.cid();
	}
    public void setcid(String s)
    {
    	this.cid=s;
    }
    public String getcid()
    {
    	return this.cid;
    }
    
    public void setZip (String zip)
    {
        this.zip = zip;
    }

    public String getPhone ()
    {
        return phone;
    }

    public void setPhone (String phone)
    {
        this.phone = phone;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getStreet ()
    {
        return street;
    }

    public void setStreet (String street)
    {
        this.street = street;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

}
