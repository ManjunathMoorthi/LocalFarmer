package DataGeneration;

public class managereport12 {
	private int mrid;
    private String name;
    private int orders_placed;
    private int orders_cancelled;
    private int  orders_open;
    private int orders_delivered;

  

    public int getMrid ()
    {
        return mrid;
    }

    public void setMrid (int s1)
    {
        this.mrid = s1;
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

}
