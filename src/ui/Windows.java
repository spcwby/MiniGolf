package ui;

import core.Main;

/**
 * changes the windows from panel to panel
 * 
 * @author jtc
 *
 */
public class Windows {
	GolfFrame[] frames = new GolfFrame[3];
	GolfFrame currentFrame;
	Main main;
	
	public Windows(Main m)
	{
		main = m;
	}
	
	public void set(int i)
	{
		currentFrame = frames[i];
	}

}
