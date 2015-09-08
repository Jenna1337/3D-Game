package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameSelect implements ActionListener
{
	private java.io.PrintStream logs;
	private boolean shouldLog = false,
			cmdStart = false;
	public GameSelect(String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		if(args.length>0)
			getArgs(args);
		if(shouldLog)
			logs = new java.io.PrintStream(new File("GameSelect.log"),"UTF-16");
		if(cmdStart==false)
		{
			JFrame frame = new JFrame("Game Select");
			JPanel panel = new JPanel();

			JButton newg = new JButton("Game 1");
			newg.addActionListener(this);
			newg.setActionCommand("game1");
			panel.add(newg);

			JButton load = new JButton("Game 2");
			load.addActionListener(this);
			panel.add(load);

			frame.add(panel);
			frame.pack();
			frame.setVisible(true);
		}
	}
	private void getArgs(String[] args)
	{
		String[] logargs = {"-log", "-L"},
				startargs = {"-start", "-play", "-P", "-S", "-p", "-s"};
		System.out.println(java.util.Arrays.deepToString(args));
		if(equalsAny(args, logargs))
			shouldLog = true;
		if(equalsAny(args, startargs))
		{
			try
			{
				startGame(args[gi(args, startargs)+1]);
			}
			catch(ArrayIndexOutOfBoundsException aioobe)
			{

			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		System.out.println(arg0.getActionCommand());
		startGame(arg0.getActionCommand());
	}
	public void startGame(String gamename)
	{
		try {
			//Try to start game
			Game game = (Game) Class.forName(gamename).newInstance();
			if(shouldLog)
				logs.println(Game.getDateTime()+" "+"Started game successfully: "+game.gameTitle);
		} catch (InstantiationException e) {
			String errstring = "Error: could not start game: "+gamename;
			if(shouldLog)
				logs.println(Game.getDateTime()+" "+errstring);
			System.err.println(errstring);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			String errstring = "Error: game not found: "+gamename;
			if(shouldLog)
				logs.println(Game.getDateTime()+" "+errstring);
			System.err.println(errstring);
		}
	}
	private static boolean equalsAny(Object[] a, Object[] b)
	{
		for(int i1=0;i1<a.length;++i1)
			for(int i2=0;i2<b.length;++i2)
				if(a[i1].equals(b[i2]))
					return true;
		return false;
	}
	private static int gi(Object[] a, Object[] b)
	{
		for(int i1=0;i1<a.length;++i1)
			for(int i2=0;i2<b.length;++i2)
				if(a[i1].equals(b[i2]))
					return i2;
		return -1;
	}
}
