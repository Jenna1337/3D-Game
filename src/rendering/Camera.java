package rendering;

import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import game.World;


public class Camera
{
	float zAxis, elevationAngle, viewRange, viewVert = 30.0f;
	protected Point3DFloat location;
	public Camera(float x, float y, float z)
	{
		this(new Point3DFloat(x, y, z));
	}
	public Camera(Point3DFloat location)
	{
		this.location = location;
	}
	public ArrayList<LineFloat> getLinesInView(World world)
	{
		return this.getLinesInView(world.getLinesList());
	}
	public ArrayList<LineFloat> getLinesInView(ArrayList<LineFloat> lines)
	{
		ArrayList<LineFloat> lns = new ArrayList<LineFloat>();
		for(LineFloat line : lines)
			if(inView(line.getP1()) || inView(line.getP2()))
				lns.add(line);
		return lns;
	}
	public ArrayList<LineFloat> getLinesInView(LineFloat... lines)
	{
		ArrayList<LineFloat> lns = new ArrayList<LineFloat>();
		for(LineFloat line : lines)
			if(inView(line.getP1()) || inView(line.getP2()))
				lns.add(line);
		return lns;
	}
	public ArrayList<Point3DFloat> getPointsInView(World world)
	{
		return this.getPointsInView(world.getPointList());
	}
	public ArrayList<Point3DFloat> getPointsInView(ArrayList<Point3DFloat> allpoints)
	{
		ArrayList<Point3DFloat> pts = new ArrayList<Point3DFloat>();
		for(Point3DFloat point : allpoints)
			if(inView(point))
				pts.add(point);
		return pts;
	}
	public ArrayList<Point3DFloat> getPointsInView(Point3DFloat... allpoints)
	{
		ArrayList<Point3DFloat> pts = new ArrayList<Point3DFloat>();
		for(Point3DFloat point : allpoints)
			if(inView(point))
				pts.add(point);
		return pts;
	}
	private boolean inView(Point3DFloat point)
	{
		return calcAngle(point)<90;
	}
	public RenderPlane getViewPlane()
	{
		Point3DFloat p1, p2, p3;
		/*Bottom left*/
		p1 = getPointAtAngle(zAxis-viewRange/2, elevationAngle-viewVert/2);
		/*Bottom right*/
		p2 = getPointAtAngle(zAxis+viewRange/2, elevationAngle-viewVert/2);
		/*Top left*/
		p3 = getPointAtAngle(zAxis-viewRange/2, elevationAngle+viewVert/2);
		return new RenderPlane(p1, p2, p3);
	}
	private double calcAngle(Point3DFloat point)
	{
		return calcAngle(point, this.getPointAtAngle());
	}
	public double calcAngle(Point3DFloat p1, Point3DFloat p2)
	{
		return Math.atan2(p2.getY()-p1.getY(),p2.getX()-p1.getX())*180.0/Math.PI;
	}
	private Point3DFloat getPointAtAngle()
	{
		return getPointAtAngle(zAxis, elevationAngle);
	}
	public static Point3DFloat getPointAtAngle(float zAxis, float elevationAngle)
	{
		return getPointAtAngle(zAxis, elevationAngle, 1.0f, false);
	}
	private static Point3DFloat getPointAtAngle(float zAxis, float elevationAngle, float r, boolean radians)
	{
		if(!radians)
		{
			zAxis *= Math.PI / 180;
			elevationAngle *= Math.PI / 180;
		}
		float x, y, z;
		x = (float)(r * Math.cos(zAxis) * Math.sin(elevationAngle));
		y = (float)(r * Math.sin(zAxis) * Math.sin(elevationAngle));
		z = (float)(r * Math.cos(elevationAngle));
		return new Point3DFloat(x, y, z);
	}
	
	public ArrayList<Point2DFloat> getPointsIn2DAsFloats(ArrayList<Point3DFloat> pts3d)
	{
		ArrayList<Point2DFloat> pts2d = new ArrayList<Point2DFloat>();
		Point3DFloat center = Math3D.midpoint(this.getViewPlane().getP3(), this.getViewPlane().getP2());
		
		double angleZ = calcAngle(new Point3DFloat(center), new Point3DFloat(center.getX(), 0, center.getZ()));
		
		double angleEle = calcAngle(center, new Point3DFloat(center.getX(), center.getY(), 0));
		
		
		for(Point3DFloat p3d : pts3d)
		{
			pts2d.add(getPoint2DFloat(p3d, angleEle, angleZ));
		}
		
		return pts2d;
	}
	public Point2DFloat getPoint2DFloat(Point3DFloat pointt, double angleEle, double angleZ)
	{
		Point3DFloat point = new Point3DFloat(pointt);
		Point2DFloat temp = rotate(new Point2DFloat(point.getX(), point.getY()),
				angleZ,
				new Point2DFloat(location.getX(), location.getY()));
		
		point.setX(temp.getX());
		point.setY(temp.getY());
		
		Point2DFloat fin = rotate(new Point2DFloat(point.getX(), point.getZ()),
				angleEle,
				new Point2DFloat(location.getX(), location.getZ()));
		
		return fin;
	}
	private static Point2DFloat rotate(Point2DFloat old, double angle, Point2DFloat origin)
	{
		double[] pt = {old.getX(), old.getY()};
		AffineTransform.getRotateInstance(Math.toRadians(angle), origin.getX(), origin.getY())
		.transform(pt, 0, pt, 0, 1); // specifying to use this double[] to hold coords
		return new Point2DFloat((float)pt[0], (float)pt[1]);
	}
}
