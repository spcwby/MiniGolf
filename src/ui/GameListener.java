package ui;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import core.GameData;
import core.Main;

public class GameListener extends FrameListener {

	public GameListener(JFrame f, Main m) {
		// TODO Auto-generated constructor stub
		super(f, m);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		GameData g = main.game;
		switch(e.getKeyCode()) {
		case UP:			
			g.angle = g.angle > 2*Math.PI || g.angle < 0 ? 2*Math.PI : g.angle - .05 ;
			break;
		case DOWN:
			g.angle = g.angle < 0 || g.angle > 2*Math.PI ? 0 : g.angle + .05 ;
			break;
		case LEFT:
			main.game.power += 1;
			break;
		case RIGHT:
			main.game.power -= 1;
			break;
		case B: // toggles information such as power and angle of the shot
			((GameFrame) main.frame2).hideInfo = !((GameFrame) main.frame2).hideInfo;
			break;
		case A:
			System.out.println("shot fired!");
			g.ball[0].x = (int) (g.ball[0].x + Math.cos(g.angle)*g.power);
			g.ball[0].y = (int) (g.ball[0].y + Math.sin(g.angle)*g.power);
			g.power = 40.0;
			break;
		case START:
			main.frame1.setVisible(false);
			main.frame2.setVisible(false);
			main.frame3.setVisible(true);
			break;
		case QUIT:
			System.exit(0);
		}
		((GameFrame) main.frame2).canvas.repaint();
		if(main.m!=null) System.out.println(main.m.getZ((int) g.ball[0].x, (int) g.ball[0].y));
	}

}
