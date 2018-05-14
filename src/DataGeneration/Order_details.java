package DataGeneration;

public class Order_details {
	

    
    private String fspid;
    private String name;
    private String amount;
    private String price;
    private double line_item_total;
   
    public double getLine_item_total ()
    {
        return line_item_total;
    }

    public void setLine_item_total (double line_item_total)
    {
        this.line_item_total = line_item_total;
    }
    

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getFspid ()
    {
        return fspid;
    }

    public void setFspid (String fspid)
    {
        this.fspid = fspid;
    }

    public String getOrder_size ()
    {
        return amount;
    }

    public void setOrder_size (String order_size)
    {
        this.amount = order_size;
    }

}
