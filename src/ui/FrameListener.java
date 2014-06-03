package ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import core.Main;

public abstract class FrameListener implements KeyListener {
	JFrame frame;
	Main main;
	static final int 	UP = KeyEvent.VK_W, 		DOWN = KeyEvent.VK_S,
						LEFT = KeyEvent.VK_A,		RIGHT = KeyEvent.VK_D,
						B = KeyEvent.VK_O,			A = KeyEvent.VK_P,
						START = KeyEvent.VK_SPACE,	QUIT = KeyEvent.VK_Q;
	
	public FrameListener(JFrame f, Main m)
	{
		frame = f;
		main = m;
		frame.addKeyListener(this);
	}

	public abstract void keyPressed(KeyEvent e);
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}
