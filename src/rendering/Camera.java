package rendering;

import javafx.geometry.Point3D;

public class Camera extends javafx.scene.PerspectiveCamera
{
	protected Point3D location;
	public Camera(float x, float y, float z, double fov)
	{
		this(new Point3D(x, y, z), fov);
	}
	public Camera(Point3D location, double fov)
	{
		super(true);
		this.location = location;
		this.setFieldOfView(fov);
	}
}
