package rendering;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
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
	public void load(World toload)
	{
		this.world = toload;
	}
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		//TODO draw world
	}
}
