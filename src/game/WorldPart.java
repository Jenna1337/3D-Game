package game;

import java.util.ArrayList;

import rendering.LineFloat;
import rendering.Point3DFloat;
import rendering.shapes.Shape3D;

@SuppressWarnings("serial")
public abstract class WorldPart extends Shape3D
{
	public abstract ArrayList<LineFloat> getLines();
	public abstract ArrayList<Point3DFloat> getPoints();
}
