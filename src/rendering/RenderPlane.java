package rendering;

public class RenderPlane
{
	private Point3DFloat p1, p2, p3;
	public RenderPlane(Point3DFloat... points)
	{
		setP1(points[0]);
		setP2(points[1]);
		setP3(points[2]);
	}
	public Point3DFloat getP1()
	{
		return p1;
	}
	public void setP1(Point3DFloat p1)
	{
		this.p1 = p1;
	}
	public Point3DFloat getP2()
	{
		return p2;
	}
	public void setP2(Point3DFloat p2)
	{
		this.p2 = p2;
	}
	public Point3DFloat getP3()
	{
		return p3;
	}
	public void setP3(Point3DFloat p3)
	{
		this.p3 = p3;
	}
}
