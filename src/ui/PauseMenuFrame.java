package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PauseMenuFrame extends AbstractFrame {
	private static final long serialVersionUID = 4877390710416923428L;
	static final int HEIGHT = 468, WIDTH = 800;
	static final String TITLE = "pause menu";
	static final String PATH = "/Users/jtc/Desktop/mgfiles/paused2.png";
	BufferedImage splashScreen;
	public boolean selectedItem = true;
	
	public Canvas canvas = new Canvas() {
		private static final long serialVersionUID = -8637656161369997296L;
		public void paint(Graphics g)
		{
			try {
				g.drawImage(ImageIO.read(new File(PATH)), 0, 0, Color.GRAY, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.setColor(Color.MAGENTA);
			if(selectedItem) g.drawRect(460, 173, 238, 50);
			else g.drawRect(460, 253, 238, 50);
		}
	};
	
	public PauseMenuFrame(boolean visible)
	{
		super(TITLE, HEIGHT, WIDTH, false);
		try {
			add(new JLabel((new ImageIcon(ImageIO.read(new File(PATH))))));
			add(canvas);
		}
		catch (IOException e) { e.printStackTrace(); }
		setResizable(false);
		setVisible(visible);
	}

	
	public void run() {
		// probably need something here later
	}
}
