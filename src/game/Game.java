package game;

import java.io.File;

public class Game
{
	protected String gameTitle = "<Game title here>";
	private java.io.PrintStream log;
	
	public Game()
	{
		logStart(false);
		
		World world = new World();
		
		
		GameWindow window = new GameWindow(this, world);
		window.load(world);
		window.setVisible(true);
	}
	
	/**Writes the text to the log file.**/
	public void log(String text)
	{
		log.println(getDateTime()+" "+text);
	}
	private java.io.PrintStream CreateLogPrintStream(boolean overwrite)
	{
		try
		{
			String filename;
			if(overwrite)
				filename = gameTitle.replaceAll("[^A-Za-z0-9 ]", "") + getDateTime()+".log";
			else 
				filename = gameTitle.replaceAll("[^A-Za-z0-9 ]", "") +".log";
			java.io.PrintStream logc = new java.io.PrintStream(new File(filename),"UTF-16");
			return logc;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public void logStart(boolean overwrite)
	{
		log = CreateLogPrintStream(overwrite);
		log("Starting");
	}
	public void logExit(int status)
	{
		if(status != 0)
			log("Error code: "+status);
		log("Exiting");
		log.close();
		//System.wait(10.0);
		System.exit(status);
	}
	public static String getDateTime()
	{
		return new java.text.SimpleDateFormat("yyyyMMdd_HHmm-ss_SSS").format(System.currentTimeMillis());
	}
}
