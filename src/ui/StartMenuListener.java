package ui;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import core.Main;

public class StartMenuListener extends FrameListener {

	public StartMenuListener(JFrame f, Main main) {
		super(f, main);
	}

	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyChar()==START) {
			main.frame1.setVisible(false);
			main.frame2.setVisible(true);
			main.frame3.setVisible(false);
		}
	}

}
