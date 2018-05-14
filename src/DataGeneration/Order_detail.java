package DataGeneration;

public class Order_detail {
	private String fspid;
	 private double amount;
	 public String getFspid ()
	    {
	        return fspid;
	    }

	    public void setFspid (String fspid)
	    {
	        this.fspid = fspid;
	    }
	    public double getamount ()
	    {
	        return amount;
	    }

	    public void setamount (double line_item_total)
	    {
	        this.amount = line_item_total;
	    }
}
