package rendering.shapes;

import java.util.ArrayList;

import rendering.LineFloat;

public abstract class Shape3D
{
	public ArrayList<LineFloat> lines = new ArrayList<LineFloat>();
	public Shape3D(LineFloat... lines)
	{
		addLines(lines);
	}
	public void addLines(LineFloat... lines)
	{
		for(LineFloat l : lines)
		{
			this.lines.add(l);
		}
	}
}
