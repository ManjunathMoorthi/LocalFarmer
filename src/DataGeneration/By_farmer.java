package DataGeneration;

public class By_farmer {
	 private String fid;
	 private String name;
	 private int orders_placed;
	    private double total_revenue;
	    private int orders_delivered;
	    private int orders_cancelled;
	    private int orders_open;
	    private double products_revenue;
	    private double delivery_revenue;
	    private double lftu_fees=0.03d;

	    private double payable_to_farm;
	    public String getFid ()
	    {
	        return fid;
	    }

	    public void setFid (String fid)
	    {
	        this.fid = fid;
	    }

	    public double getTotal_revenue ()
	    {
	        return total_revenue;
	    }

	    public void setTotal_revenue (double total_revenue)
	    {
	        this.total_revenue = total_revenue;
	    }

	    public double getDelivery_revenue ()
	    {
	        return delivery_revenue;
	    }

	    public void setDelivery_revenue (double delivery_revenue)
	    {
	        this.delivery_revenue = delivery_revenue;
	    }

	    public int getOrders_cancelled ()
	    {
	        return orders_cancelled;
	    }

	    public void setOrders_cancelled (int orders_cancelled)
	    {
	        this.orders_cancelled = orders_cancelled;
	    }

	    public int getOrders_open ()
	    {
	        return orders_open;
	    }

	    public void setOrders_open (int orders_open)
	    {
	        this.orders_open = orders_open;
	    }

	    public String getName ()
	    {
	        return name;
	    }

	    public void setName (String name)
	    {
	        this.name = name;
	    }

	    public double getPayable_to_farm ()
	    {
	        return payable_to_farm;
	    }

	    public void setPayable_to_farm (double payable_to_farm)
	    {
	        this.payable_to_farm = payable_to_farm;
	    }

	    public int getOrders_delivered ()
	    {
	        return orders_delivered;
	    }

	    public void setOrders_delivered (int orders_delivered)
	    {
	        this.orders_delivered = orders_delivered;
	    }

	    public int getOrders_placed ()
	    {
	        return orders_placed;
	    }

	    public void setOrders_placed (int orders_placed)
	    {
	        this.orders_placed = orders_placed;
	    }

	    public double getProducts_revenue ()
	    {
	        return products_revenue;
	    }

	    public void setProducts_revenue (double products_revenue)
	    {
	        this.products_revenue = products_revenue;
	    }

	    public double getLftu_fees ()
	    {
	        return lftu_fees;
	    }

	    public void setLftu_fees (double lftu_fees)
	    {
	        this.lftu_fees = lftu_fees;
	    }


}
