package game;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import rendering.Renderer;

@SuppressWarnings("serial")
public class GameWindow extends JFrame implements ComponentListener, WindowListener
{
	Renderer panel = new Renderer(null);
	private int windowWidth = this.getWidth();
	int windowHeight=this.getHeight();
	int wmod=this.getWidth() - this.panel.getWidth();
	int hmod=this.getHeight()-this.panel.getHeight();
	public GameWindow()
	{
		super("Game Title");
		this.add(panel);
		this.addComponentListener(this);
		this.addWindowListener(this);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		// TODO Auto-generated constructor stub
	}
	
	public GameWindow(World world)
	{
		this();
		this.load(world);
	}
	
	public void load(World world)
	{
		 this.panel.load(world);
	}
	
	public void componentHidden(ComponentEvent arg0){}
	public void componentMoved(ComponentEvent arg0){}
	public void componentResized(ComponentEvent arg0)
	{
		if(windowWidth != this.getWidth() ||
				windowHeight!=this.getHeight())
		{
			windowWidth = this.getWidth();
			windowHeight=this.getHeight();
			int wmod=this.getWidth() - this.panel.getWidth();
			int hmod=this.getHeight()-this.panel.getHeight();
			
			try
			{
				this.panel.setPreferredSize(new java.awt.Dimension(windowWidth-wmod, windowHeight-hmod));
				this.panel.setSize(windowWidth-wmod, windowHeight-hmod);//78
				System.out.println("Screen resized to "+this.panel.getSize());
			}
			catch(IllegalArgumentException iae)
			{
			}
		}
	}
	public void componentShown(ComponentEvent arg0){}
	
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub
	}
	
	public void windowClosed(WindowEvent e){}
	
	public void windowClosing(WindowEvent e)
	{
		Game.log("Exiting...");
		// TODO Auto-generated method stub
		this.dispose();
		System.out.println("Exiting...");
		System.gc();
		System.exit(0);
	}
	
	public void windowDeactivated(WindowEvent e)
	{
		//Auto Pause?
		// TODO Auto-generated method stub
	}
	
	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
	}
	
	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub
	}
	
	public void windowOpened(WindowEvent e)
	{
		// TODO Auto-generated method stub
	}
}
