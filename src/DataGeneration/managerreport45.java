package DataGeneration;

import java.util.List;

public class managerreport45 {
	private int mrid;
	
	 private String name;
	 private String start_date;
	 private String end_date;
	 private int orders_placed;
	 private int orders_delivered;
	 private int orders_open;
	    private int orders_cancelled;
	    private double total_revenue;
	    private double total_products_revenue;
	    private double total_delivery_revenue;
	    private double lf2u_management_fee;
	    private double total_lftu_fees;
	    private double total_payable_to_farms;
	    private List<By_farmer> by_farmer;
	   



	   

	    

	    

	    public int getOrders_open ()
	    {
	        return orders_open;
	    }

	    public void setOrders_open (int orders_open)
	    {
	        this.orders_open = orders_open;
	    }

	    public int getOrders_cancelled ()
	    {
	        return orders_cancelled;
	    }

	    public void setOrders_cancelled (int orders_cancelled)
	    {
	        this.orders_cancelled = orders_cancelled;
	    }

	    public double getTotal_products_revenue ()
	    {
	        return total_products_revenue;
	    }

	    public void setTotal_products_revenue (double total_products_revenue)
	    {
	        this.total_products_revenue = total_products_revenue;
	    }

	    public double getTotal_payable_to_farms ()
	    {
	        return total_payable_to_farms;
	    }

	    public void setTotal_payable_to_farms (double total_payable_to_farms)
	    {
	        this.total_payable_to_farms = total_payable_to_farms;
	    }

	    public int getMrid ()
	    {
	        return mrid;
	    }

	    public void setMrid (int mrid)
	    {
	        this.mrid = mrid;
	    }

	    public double getTotal_revenue ()
	    {
	        return total_revenue;
	    }

	    public void setTotal_revenue (double total_revenue)
	    {
	        this.total_revenue = total_revenue;
	    }

	    public String getEnd_date ()
	    {
	        return end_date;
	    }

	    public void setEnd_date (String end_date)
	    {
	        this.end_date = end_date;
	    }

	    public String getName ()
	    {
	        return name;
	    }

	    public void setName (String name)
	    {
	        this.name = name;
	    }

	    public List<By_farmer> getBy_farmer ()
	    {
	        return by_farmer;
	    }

	    public void setBy_farmer (List<By_farmer> by_farmer)
	    {
	        this.by_farmer = by_farmer;
	    }

	    public int getOrders_delivered ()
	    {
	        return orders_delivered;
	    }

	    public void setOrders_delivered (int orders_delivered)
	    {
	        this.orders_delivered = orders_delivered;
	    }

	    public double getTotal_delivery_revenue ()
	    {
	        return total_delivery_revenue;
	    }

	    public void setTotal_delivery_revenue (double total_delivery_revenue)
	    {
	        this.total_delivery_revenue = total_delivery_revenue;
	    }

	    public double getLf2u_management_fee ()
	    {
	        return lf2u_management_fee;
	    }

	    public void setLf2u_management_fee (double lf2u_management_fee)
	    {
	        this.lf2u_management_fee = lf2u_management_fee;
	    }

	    public double getTotal_lftu_fees ()
	    {
	        return total_lftu_fees;
	    }

	    public void setTotal_lftu_fees (double total_lftu_fees)
	    {
	        this.total_lftu_fees = total_lftu_fees;
	    }

	    public String getStart_date ()
	    {
	        return start_date;
	    }

	    public void setStart_date (String start_date)
	    {
	        this.start_date = start_date;
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
