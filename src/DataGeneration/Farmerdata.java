package DataGeneration;

public class Farmerdata {

    private String fid;

    
    private Farm_info farm_info;
    private Personal_info personal_info;
    private String[] delivers_to;
    private double delivery_charge;

    public Farmerdata()
    {
    	this.fid=Idgen.fid();
    }
    public void setfid(String s)
    {
    	this.fid=s;
    }

    public String getfid()
    {
    	return this.fid;
    }

    public String[] getDelivers_to ()
    {
        return delivers_to;
    }

    public void setDelivers_to (String[] delivers_to)
    {
        this.delivers_to = delivers_to;
    }

    public Personal_info getPersonal_info ()
    {
        return personal_info;
    }

    public void setPersonal_info (Personal_info personal_info)
    {
        this.personal_info = personal_info;
    }

    public Farm_info getFarm_info ()
    {
        return farm_info;
    }

    public void setFarm_info (Farm_info farm_info)
    {
        this.farm_info = farm_info;
    }
    public double get_Delivery()
    {
    	return this.delivery_charge;
    }
    public void setdeliverycharges(double d)
    {
    	this.delivery_charge=d;
    }
}
