package rendering;

public class Point3DFloat
{
	private float x,y,z;
	public Point3DFloat(float x,float y,float z)
	{
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}
	/**Same as clone()**/
	public Point3DFloat(Point3DFloat toCopy)
	{
		this.setX(toCopy.getX());
		this.setY(toCopy.getY());
		this.setZ(toCopy.getZ());
	}
	public Point3DFloat translate(float x,float y,float z)
	{
		this.setX(this.getX() + x);
		this.setY(this.getY() + y);
		this.setZ(this.getZ() + z);
		return this;
	}
	@Override
	public Object clone()
	{
		return new Point3DFloat(getX(), getY(), getZ());
	}
	@Override
	public String toString()
	{
		return "x = "+getX()+", y = "+getY()+", z = "+getZ();
	}
	public double distance(Point3DFloat point)
	{
		return Math.sqrt(
				Math.pow(this.getX()-point.getX(), 2)+
				Math.pow(this.getY()-point.getY(), 2)+
				Math.pow(this.getZ()-point.getZ(), 2)
				);
	}
	public void setLocation(float f, float g, float h)
	{
		this.x = f;
		this.y = g;
		this.z = h;
	}
	public Point3DFloat translate(int dx, int dy, int dz)
	{
		return this.translate((float)dx, (float)dy, (float)dz);
	}
	public Point3DFloat copyTranslate(int dx, int dy, int dz)
	{
		return this.copyTranslate((float)dx, (float)dy, (float)dz);
	}
	public Point3DFloat copyTranslate(float dx, float dy, float dz)
	{
		return ((Point3DFloat)this.clone()).translate(dx, dy, dz);
	}
	public float getX()
	{
		return x;
	}
	public void setX(float x)
	{
		this.x = x;
	}
	public float getY()
	{
		return y;
	}
	public void setY(float y)
	{
		this.y = y;
	}
	public float getZ()
	{
		return z;
	}
	public void setZ(float z)
	{
		this.z = z;
	}
}
