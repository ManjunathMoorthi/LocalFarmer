package DataGeneration;
public class catalogmange {
	private String name;

    private String gcpid;
    public catalogmange()
    {
    	this.gcpid=Idgen.gcpid();
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }
    public void setgcpid(String s)
    {
    	this.gcpid=s;
    }

    public String getGcpid ()
    {
        return this.gcpid;
    }

   

}
