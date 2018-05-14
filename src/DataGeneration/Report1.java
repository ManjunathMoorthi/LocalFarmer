package DataGeneration;

import java.util.List;

public class Report1 {
	private int frid;

    private String name;

    private List<orders> orders;

    public int getFrid ()
    {
        return frid;
    }

    public void setFrid (int frid)
    {
        this.frid = frid;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public List<orders> getOrders ()
    {
        return orders;
    }

    public void setOrders (List<orders> orders)
    {
        this.orders = orders;
    }
}
