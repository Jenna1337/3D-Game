package rendering;

public class LineFloat
{
	private Point3DFloat p1, p2;
	public LineFloat(Point3DFloat p1, Point3DFloat p2)
	{
		this.setP1(p1);
		this.setP2(p2);
	}
	public Point3DFloat getP2()
	{
		return p2;
	}
	public void setP2(Point3DFloat p2)
	{
		this.p2 = p2;
	}
	public Point3DFloat getP1()
	{
		return p1;
	}
	public void setP1(Point3DFloat p1)
	{
		this.p1 = p1;
	}
}
