package rendering.shapes;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import rendering.Point3DFloat;

//XXX Delete
@Deprecated
@SuppressWarnings("serial")
public class Line3D extends Component implements PropertyChangeListener
{
	private Point3DFloat p1;
	private Point3DFloat p2;
	public Line3D(Point3DFloat p1, Point3DFloat p2)
	{
		this.setP1(p1);
		this.setP2(p2);
	}
	@Override
	public void propertyChange(PropertyChangeEvent eve)
	{
		this.firePropertyChange("EndPointLocation", null, this);
	}
	@Override
	public String toString()
	{
		return this.getClass().getName()+"{"+this.getP1().toString()+", "+this.getP2().toString()+"}";
	}
	public Point3DFloat getP1()
	{
		return p1;
	}
	public void setP1(Point3DFloat p12)
	{
		this.p1 = p12;
	}
	public Point3DFloat getP2()
	{
		return p2;
	}
	public void setP2(Point3DFloat p2)
	{
		this.p2 = p2;
	}
}
