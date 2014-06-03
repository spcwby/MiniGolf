package models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import ui.GameFrame;
import core.Main;

public class Map {
	Image currentMap;
	BufferedImage zMap, ball, flag;
	ArrayList<GolfObject> golfObjects;
	Rectangle screenBounds = new Rectangle(GameFrame.WIDTH, GameFrame.HEIGHT);
	
	String[] filepaths = {
		"/Users/jtc/Desktop/color.jpg",
		"/Users/jtc/Desktop/gray.jpg"
	};

	public int flagX  = 0, flagY = 0;
	{
		Random r = new Random();
		flagX = r.nextInt((int) screenBounds.getWidth());
		flagY = r.nextInt((int) screenBounds.getHeight());
	}
	
	Main main;
	/**
	 * keys for map numbers:
	 * 
	 * 1 through 18 are reserved for normal holes
	 * 0 is the splash screen
	 * 19 is the pause menu / scorecard.
	 * 
	 */
	public Map(Main m)
	{
		main = m;
		setMap(0);
		

		ball = toBufferedImage(load("/models/ball2.png"));
		flag = toBufferedImage(load("/models/flag.png"));
		
	}
	
	public Image load(String imageID)
	{
		Image i = null;
		try { i = ImageIO.read(getClass().getResourceAsStream(imageID)); }
		catch(Exception e) { e.printStackTrace(); }
		return i;
	}
	
	public void setMap(int mapNumber)
	{
		Image map = load("/models/hole"+mapNumber+".png");
		if(!screenBounds.equals(new Rectangle(1920, 1080))) 
			map = scale(map, screenBounds.width, screenBounds.height);
		currentMap = map;
		
		zMap = toBufferedImage(map);
	}
	
	/**
	 * Converts a given Image into a BufferedImage
	 *
	 *	not mine.
	 *
	 * @param img The Image to be converted
	 * @return The converted BufferedImage
	 */
	public static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    // Return the buffered image
	    return bimage;
	}
	
	public Image scale(Image b, int width, int height)
	{
		/*BufferedImage a =
			new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		AffineTransform at = new AffineTransform();
		
		double xScaleFactor = ((double) b.getWidth())/((double) width),
			   yScaleFactor = ((double) b.getHeight())/((double) height);
		
		at.scale(xScaleFactor, yScaleFactor);
		a = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR).filter(b, a);
		return a;*/
		return b.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	}
	
	public BufferedImage getBall()
	{
		return ball;
	}
	
	public BufferedImage getFlag()
	{
		return flag;
	}
	
	public int getZ(int x, int y)
	{
		Color c = new Color(zMap.getRGB(x, y));
		double i = 0.2126*c.getRed() + 0.7152*c.getGreen() + 0.0722*c.getBlue();
		System.out.println(i);
		return (int) i;
	}
	
	public Image getCurrentMap()
	{
		return currentMap;
	}
}
