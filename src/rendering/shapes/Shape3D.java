package rendering.shapes;

import java.awt.Component;
import java.util.ArrayList;

import rendering.LineFloat;

@SuppressWarnings("serial")
public abstract class Shape3D extends Component
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
