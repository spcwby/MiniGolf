package ui;

import java.awt.event.KeyEvent;

import core.Main;

import javax.swing.JFrame;

public class PauseMenuListener extends FrameListener {
	public PauseMenuListener(JFrame f, Main m)
	{
		// TODO Auto-generated constructor stub
		super(f, m);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyChar()==START) {
			main.frame1.setVisible(false);
			main.frame2.setVisible(true);
			main.frame3.setVisible(false);
		} else if(e.getKeyCode()==UP || e.getKeyCode()==DOWN) {
			System.out.println("hi");
			((PauseMenuFrame) main.frame3).selectedItem
			 = !((PauseMenuFrame) main.frame3).selectedItem;
		} else if(e.getKeyCode()==A) {
			if(((PauseMenuFrame)main.frame3).selectedItem) {
				System.out.println("game ended");
				/* make sure to reset any game data here later. */
				main.frame1.setVisible(true);
				main.frame2.setVisible(false);
				main.frame3.setVisible(false);
			}else {
				System.out.println("music toggled");
				//((GameFrame) main.frame2).musicOn
				//= !((GameFrame) main.frame2).musicOn;
			}
		}
		((PauseMenuFrame) main.frame3).canvas.repaint();
	}
}
