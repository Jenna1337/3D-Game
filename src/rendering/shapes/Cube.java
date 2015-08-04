package rendering.shapes;

import rendering.LineFloat;
import rendering.Point3DFloat;

@SuppressWarnings({"serial"})
public class Cube extends Shape3D
{
	protected Point3DFloat origin;
	private Point3DFloat top_front_left,		top_front_right,
					top_back_left,		top_back_right,
					bottom_front_left,	bottom_front_right,
					bottom_back_left,	bottom_back_right;
	private LineFloat top_front,
		top_left,		top_right,
				top_back,
			
			front_left,	front_right,
			back_left,	back_right,
			
				bottom_front,
		bottom_left,	bottom_right,
				bottom_back;
	public Cube(Point3DFloat location)
	{
		super();
		setLocation(location);
		
		//TO==DO
	}
	public void setLocation(Point3DFloat location)
	{
		Point3DFloat old = new Point3DFloat(origin);
		while(lines.size()>0)
			lines.remove(0);
		this.origin=location;
		
		/* 
		 * ^     _ 
		 * |     /|
		 * |    /  
		 * Z   X   
		 * |  /    
		 * | /     
		 * |/      
		 * +---Y-->
		 */
		top_front_left   =origin.copyTranslate(0, 1, 1); top_front_right   =origin.copyTranslate(1, 1, 1);
		top_back_left    =origin.copyTranslate(0, 0, 1); top_back_right    =origin.copyTranslate(1, 0, 1);
		bottom_front_left=origin.copyTranslate(0, 1, 0); bottom_front_right=origin.copyTranslate(1, 1, 0);
		bottom_back_left =origin.copyTranslate(0, 0, 0); bottom_back_right =origin.copyTranslate(1, 0, 0);
		
								top_front=new LineFloat(top_front_left, top_front_right);
		top_left=new LineFloat(top_front_left, top_back_left);			top_right=new LineFloat(top_front_right, top_back_right);
								top_back=new LineFloat(top_back_left, top_back_right);
			
			front_left=new LineFloat(top_front_left, bottom_front_left);	front_right=new LineFloat(top_front_right, bottom_front_right);
			back_left=new LineFloat(top_back_left, bottom_back_left);	back_right=new LineFloat(top_back_right, bottom_back_right);
			
								bottom_front=new LineFloat(bottom_front_left, bottom_front_right);
		bottom_left=new LineFloat(bottom_front_left, bottom_back_left);	bottom_right=new LineFloat(bottom_front_right, bottom_back_right);
								bottom_back=new LineFloat(bottom_back_left, bottom_back_right);
		
		LineFloat[] ls = new LineFloat[]{top_front,
		top_left,		top_right,
				top_back,
			
			front_left,	front_right,
			back_left,	back_right,
			
				bottom_front,
		bottom_left,	bottom_right,
				bottom_back};
		super.addLines(ls);
		
		this.firePropertyChange("Cube_origin", old, this.origin);
	}
	@Override
	public String toString()
	{
		return this.getClass().getName()+"{"+this.origin.getX()+", "+this.origin.getY()+", "+this.origin.getZ()+"}";
	}
}
