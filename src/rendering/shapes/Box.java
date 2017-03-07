package rendering.shapes;

import javafx.geometry.Point3D;

public class Box extends javafx.scene.shape.Box
{
	protected Point3D origin;
	public Box(Point3D location)
	{
		super();
		setLocation(location);
	}
	public void setLocation(Point3D location)
	{
		origin=location;
	}
	@Override
	public String toString()
	{
		return this.getClass().getName()+"{"+this.origin.getX()+", "+this.origin.getY()+", "+this.origin.getZ()+"}";
	}
}
