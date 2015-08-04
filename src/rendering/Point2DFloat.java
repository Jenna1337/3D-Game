package rendering;

public class Point2DFloat
{
	private float x,y;
	public Point2DFloat(float x,float y)
	{
		this.setX(x);
		this.setY(y);
	}
	/**Same as clone()**/
	public Point2DFloat(Point2DFloat toCopy)
	{
		this.setX(toCopy.getX());
		this.setY(toCopy.getY());
	}
	public Point2DFloat translate(float x,float y)
	{
		this.setX(this.getX() + x);
		this.setY(this.getY() + y);
		return this;
	}
	@Override
	public Object clone()
	{
		return new Point2DFloat(getX(), getY());
	}
	@Override
	public String toString()
	{
		return "x = "+getX()+", y = "+getY();
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
}
