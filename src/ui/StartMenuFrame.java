package ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * inheritance. lots of it.
 * @author jtc
 *
 */
public class StartMenuFrame extends AbstractFrame {
	private static final long serialVersionUID = 5664443284403058559L;
	static final int HEIGHT = 356, WIDTH = 600;
	static final String TITLE = "start menu";
	static final String PATH = "/Users/jtc/Desktop/mgfiles/ssLite.png";
	BufferedImage splashScreen;
	
	public StartMenuFrame(boolean visible)
	{
		super(TITLE, HEIGHT, WIDTH, false);
		try {
			splashScreen = ImageIO.read(new File(PATH));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(new JLabel((new ImageIcon(splashScreen))));
		setResizable(false);
		setVisible(visible);
	}


	
	public void run() {
		// probably need something here later
	}
}
