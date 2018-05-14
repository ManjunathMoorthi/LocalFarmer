package DataGeneration;

public class report3 {
	private int frid;
	 private String name;
	 private String start_date;
    private String end_date;
    private int orders_placed;
    private int orders_cancelled;
    private int orders_delivered;
    private double products_revenue;
    private double delivery_revenue;

    public int getFrid ()
    {
        return frid;
    }

    public void setFrid (int s1)
    {
        this.frid = s1;
    }

    public String getEnd_date ()
    {
        return end_date;
    }

    public void setEnd_date (String end_date)
    {
        this.end_date = end_date;
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

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
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

    public String getStart_date ()
    {
        return start_date;
    }

    public void setStart_date (String start_date)
    {
        this.start_date = start_date;
    }

    public double getProducts_revenue ()
    {
        return products_revenue;
    }

    public void setProducts_revenue (double products_revenue)
    {
        this.products_revenue = products_revenue;
    }


}
