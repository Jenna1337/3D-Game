package rendering.shapes;

import javafx.geometry.Point3D;

public interface Shape3DPositioned
{
	public Point3D getOrigin();
	public void setOrigin(Point3D newlocation);
}
