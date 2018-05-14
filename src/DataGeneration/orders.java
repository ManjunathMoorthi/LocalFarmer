package DataGeneration;

import java.util.List;

public class orders {
	private String oid;
	private double products_total;
	private double delivery_charge;
	private double order_total;
	  private String status;
	  private String order_date;
	  private String planned_delivery_date;
	  private String actual_delivery_date;
	  private Ordered_by Ordered_by;
	 private List<Order_details> order_detail;
	    private String delivery_address;
	    private String note;
	    
	   

	    public double getOrder_total ()
	    {
	        return order_total;
	    }

	    public void setOrder_total (double order_total)
	    {
	        this.order_total = order_total;
	    }

	    public List<Order_details> getOrder_detail ()
	    {
	        return order_detail;
	    }

	    public void setOrder_detail (List<Order_details> order_detail)
	    {
	        this.order_detail = order_detail;
	    }

	    public double getDelivery_charge ()
	    {
	        return delivery_charge;
	    }

	    public void setDelivery_charge (double delivery_charge)
	    {
	        this.delivery_charge = delivery_charge;
	    }

	    public double getProducts_total ()
	    {
	        return products_total;
	    }

	    public void setProducts_total (double products_total)
	    {
	        this.products_total = products_total;
	    }

	    public Ordered_by getOrdered_by ()
	    {
	        return Ordered_by;
	    }

	    public void setOrdered_by (Ordered_by ordered_by)
	    {
	        this.Ordered_by = ordered_by;
	    }

	    public String getActual_delivery_date ()
	    {
	        return actual_delivery_date;
	    }

	    public void setActual_delivery_date (String actual_delivery_date)
	    {
	        this.actual_delivery_date = actual_delivery_date;
	    }

	    public String getStatus ()
	    {
	        return status;
	    }

	    public void setStatus (String status)
	    {
	        this.status = status;
	    }

	    public String getDelivery_address ()
	    {
	        return delivery_address;
	    }

	    public void setDelivery_address (String delivery_address)
	    {
	        this.delivery_address = delivery_address;
	    }

	    public String getOid ()
	    {
	        return oid;
	    }
public void setoid(String oid)
{
	this.oid=oid;
}
	    public String getPlanned_delivery_date ()
	    {
	        return planned_delivery_date;
	    }

	    public void setPlanned_delivery_date (String planned_delivery_date)
	    {
	        this.planned_delivery_date = planned_delivery_date;
	    }

	    public String getOrder_date ()
	    {
	        return order_date;
	    }

	    public void setOrder_date (String order_date)
	    {
	        this.order_date = order_date;
	    }

	    public String getNote ()
	    {
	        return note;
	    }

	    public void setNote (String note)
	    {
	        this.note = note;
	    }

	   

}



