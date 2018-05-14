package DataGeneration;

public class corders {
	
	 private String oid;
	 private String order_date;
     private String actual_delivery_date;
     private String planned_delivery_date;
     private String status;
     private String fid;
     public corders()
    {
    	this.status="open";
    	this.order_date=Idgen.getcurrentdate();
    	this.planned_delivery_date=Idgen.getnextday();
    	
    }

     public void setactual(String s)
     {
    	 this.planned_delivery_date=s;
     }
    public String getFid ()
    {
        return fid;
    }

    public void setFid (String fid)
    {
        this.fid = fid;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getActual_delivery_date ()
    {
        return actual_delivery_date;
    }

   

    public String getOid ()
    {
        return oid;
    }

    public void setOid (String oid)
    {
        this.oid = oid;
    }

    public String getPlanned_delivery_date ()
    {
        return planned_delivery_date;
    }

    public void setPlanned_delivery_date (String s)
    {
        this.planned_delivery_date=s;
    }

    public String getOrder_date ()
    {
        return order_date;
    }

    

}
