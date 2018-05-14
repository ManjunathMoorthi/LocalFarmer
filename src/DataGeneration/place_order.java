package DataGeneration;

public class place_order {

	private String fid;
	private String oid;
    private Order_detail[] order_detail;

    private String delivery_note;
    public place_order()
    {
    	this.oid=Idgen.oid();
    }
    public String getoid()
    {
    	return this.oid;
    }

    public String getFid ()
    {
        return fid;
    }

    public void setFid (String fid)
    {
        this.fid = fid;
    }

    public Order_detail[] getOrder_detail ()
    {
        return order_detail;
    }

    public void setOrder_detail (Order_detail[] order_detail)
    {
        this.order_detail = order_detail;
    }

    public String getDelivery_note ()
    {
        return delivery_note;
    }

    public void setDelivery_note (String delivery_note)
    {
        this.delivery_note = delivery_note;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [fid = "+fid+", order_detail = "+order_detail+", delivery_note = "+delivery_note+"]";
    }
}
