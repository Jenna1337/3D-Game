package rendering.shapes;

//XXX Delete
@Deprecated
public class Point3D extends Point2D
{
	//	private int x;
	//	private int y;
	private int z;
	
	public Point3D(int x, int y, int z)
	{
		super(x,y);
		//		this.x = x;
		//		this.y = y;
		this.z = z;
	}
	public Point3D(Point3D point)
	{
		this(point.getX(), point.getY(), point.getZ());
	}
	@Override
	public Object clone()
	{
		return new Point3D(this.x, this.y, this.z);
	}
	@Override
	public boolean equals(Object obj)
	{
		return obj.toString().equals(this.toString());
	}
	@Override
	public double distance(Point2D point)
	{
		return Math.sqrt(
				Math.pow(this.getX()-point.getX(), 2)+
				Math.pow(this.getY()-point.getY(), 2)+
				Math.pow(this.getZ(), 2)
				);
	}
	public double distance(Point3D point)
	{
		return Math.sqrt(
				Math.pow(this.getX()-point.getX(), 2)+
				Math.pow(this.getY()-point.getY(), 2)+
				Math.pow(this.getZ()-point.getZ(), 2)
				);
	}
	public int getZ()
	{
		return this.z;
	}
	public void setLocation(int x, int y, int z)
	{
		this.z = z;
	}
	public Point3D translate(int dx, int dy, int dz)
	{
		this.setLocation(this.x+dx, this.y+dy, this.z + dz);
		return this;
	}
	public Point3D copyTranslate(int dx, int dy, int dz)
	{
		return ((Point3D)this.clone()).translate(dx, dy, dz);
	}
	@Override
	public String toString()
	{
		return this.getClass().getName()+" X="+this.getX()+" Y="+this.getY()+" Z="+this.getZ();
	}
}
