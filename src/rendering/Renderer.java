package rendering;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Comparator;

import game.World;

@SuppressWarnings("serial")
public class Renderer extends Panel
{
	public World world;
	Camera cam;
	public Renderer(World world)
	{
		this.world = world;
		this.setBackground(new Color(255,127,0));
		// TODO Auto-generated constructor stub
	}
	public void load(World world)
	{
		this.world = world;
	}
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
	}
	public void drawWorld()
	{
		ArrayList<Point3DFloat> pts = cam.getPointsInView(this.world.getPointList());
		pts.sort(new Comparator<Point3DFloat>() {
			public int compare(Point3DFloat  p1, Point3DFloat  p2)
			{
				return  Double.compare(cam.location.distance(p1), cam.location.distance(p2));
			}
		});
		
		RenderPlane plane =  cam.getViewPlane();
		
		Point3DFloat center = Math3D.midpoint(cam.getViewPlane().getP3(), cam.getViewPlane().getP2());
		
		double angleZ = cam.calcAngle(new Point3DFloat(center), new Point3DFloat(center.getX(), 0, center.getZ()));
		double angleEle = cam.calcAngle(center, new Point3DFloat(center.getX(), center.getY(), 0));
		
		ArrayList<Point2DFloat> pts2d = transformat(cam.getPointsIn2DAsFloats(pts), cam.getPoint2DFloat(plane.getP3(), angleEle, angleZ), 
				cam.getPoint2DFloat(plane.getP3(), angleEle, angleZ), this.getHeight(), this.getWidth());
		
		//TODO get lines and draw them
		
		
		//TODO
	}
	public void drawLine(LineFloat line)
	{
		this.getGraphics().drawLine(Math.round(line.getP1().getX()), Math.round(line.getP1().getY()), Math.round(line.getP2().getX()), Math.round(line.getP2().getY()));
	}
	public static ArrayList<Point2DFloat> transformat(ArrayList<Point2DFloat> pts, Point2DFloat topLeft, Point2DFloat bottomRight, int screenHeight, int screenWidth)
	{
		ArrayList<Point2DFloat> npts = new ArrayList<Point2DFloat>();
		
		float offX = topLeft.getX(), 
				offY = topLeft.getY();
		float coefX = screenWidth / (bottomRight.getX()-offX);
		float coefY = screenHeight / (bottomRight.getY()-offY);
		
		/*String ln = System.lineSeparator();
	    System.out.println("offX="+offX+ln+"offY="+offY+ln+"coefX="+coefX+ln+"coefY="+coefY+ln);*///TODO remove
		
		for(Point2DFloat pt : pts)
		{
			npts.add(new Point2DFloat(coefX*(pt.getX()-offX), coefY*(pt.getY()-offY)));
			//TODO
		}
		
		return npts;
	}
}
