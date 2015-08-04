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
		
		ArrayList<Point2DFloat> pts2d = cam.getPointsIn2DAsFloats(pts);
		
		//TODO get lines and draw them
		
		
		//TODO
	}
	public void drawLine(LineFloat line)
	{
		this.getGraphics().drawLine(Math.round(line.getP1().getX()), Math.round(line.getP1().getY()), Math.round(line.getP2().getX()), Math.round(line.getP2().getY()));
	}
}
