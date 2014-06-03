package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import core.GameData;
import core.Main;

public class GameFrame extends AbstractFrame {
	private static final long serialVersionUID = -7507150408519508299L;
	public static final int HEIGHT = 468, WIDTH = 800;
	static final String TITLE = "game window";
	Image splashScreen;
	BufferedImage ball;
	BufferedImage flag;
	Main main;
	Clip clip;
	public boolean hideInfo = false, musicOn = true;
	
	
	public Canvas canvas = new Canvas() {
		private static final long serialVersionUID = -5794413170362000928L;
		
		public void paint(Graphics g)
		{
			GameData game = main.game;
			
			// mainly for convenience and readability
			int ballX = (int) (game.ball[0].x),
				ballY = (int) (game.ball[0].y),
				powX = (int) (game.ball[0].x + Math.cos(game.angle)*(game.power)),
				powY = (int) (game.ball[0].y + Math.sin(game.angle)*(game.power));
			g.drawImage(splashScreen, 0, 0, null);
			if(!hideInfo) {
				g.setColor(Color.BLUE);
				g.drawString(TITLE, WIDTH-700, HEIGHT-368);
				ArrayList<String> list = game.stats();
				for(int i = 0; i<list.size(); i++)
					g.drawString(list.get(i), 400, 200-14*i);
				g.setColor(Color.BLACK);
			}
			g.setColor(Color.RED);
			g.drawLine(ballX, ballY, powX, powY);
			g.setColor(Color.BLACK);
			g.drawLine(ballX, ballY, ballX+40, ballY);
			g.drawImage(ball, ballX - GameData.BALL_RADIUS, ballY -GameData.BALL_RADIUS, null);
			g.drawImage(flag, main.m.flagX, main.m.flagY, null);

		}
	};
	
	public GameFrame(boolean visible, Main m)
	{
		super(TITLE, HEIGHT, WIDTH, false);
		main = m;
		try {
			//splashScreen = ImageIO.read(new File(PATH));
			splashScreen = m.m.getCurrentMap();
			if(splashScreen!=null) System.out.println(splashScreen);
			
			//File bmusic = new File("/Users/jtc/Desktop/mgfiles/bmusic.wav");
			AudioInputStream a = AudioSystem.getAudioInputStream(
					getClass().getResourceAsStream("/models/bmusic.wav"));
			 clip = AudioSystem.getClip();
			clip.open(a);
			clip.loop(1);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(new JLabel((new ImageIcon(splashScreen))));
		add(canvas); 
		setResizable(false);
		setVisible(visible);
		update(getGraphics());
		ball = m.m.getBall();
		flag = m.m.getFlag();
	}
	
	public void run() {
		// probably need something here later
	}

}
