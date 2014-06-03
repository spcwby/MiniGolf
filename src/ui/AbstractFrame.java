package ui;

import javax.swing.JFrame;

public abstract class AbstractFrame extends JFrame implements Runnable {
	private static final long serialVersionUID = -8199675957346622932L;

	public AbstractFrame(String title, int w, int h, boolean isVisible)
	{
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(h, w);
		setLocationRelativeTo(null);
		setVisible(isVisible);
	}

}
