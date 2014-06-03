package core;

import java.util.ArrayList;

import models.Map;
import ui.AbstractFrame;
import ui.FrameListener;
import ui.GameFrame;
import ui.GameListener;
import ui.GolfFrame;
import ui.PauseMenuFrame;
import ui.PauseMenuListener;
import ui.StartMenuFrame;
import ui.StartMenuListener;

public class Main {
	
	/**
	 * some physics constants that the game relies on:
	 */
	static final double VEL_EIGENVAL = 1.0;
	static final double ACC_EIGENVAL = 1.0;
	
	
	GameData gd;
	public Map m;
	GolfFrame start_menu, game_window, pause_menu, scorecard_window;
	GolfFrame[] windows = { start_menu, game_window, pause_menu, scorecard_window };
	

	public AbstractFrame frame1, frame2, frame3;
	public Thread frame1Thread, frame2Thread, frame3Thread;
	public ArrayList<Thread> threads = new ArrayList<Thread>();
	public FrameListener listen1, listen2, listen3;
	public GameData game = new GameData(this);
	public Physics physics;
	

	public Main()
	{
		
		System.out.println("program started");
		//m = new Map();
		//m.setMap(0);
		//System.out.println(m.getCurrentMap().getWidth());
		physics = new Physics(this);
		
		m = new Map(this);
		m.setMap(0);
		if(m.getCurrentMap()!=null) System.out.println(m.getCurrentMap());
		
		
		
		frame1Thread = new Thread(frame1 = new StartMenuFrame(true));
		listen1 = new StartMenuListener(frame1, this);
		frame2Thread = new Thread(frame2 = new GameFrame(false, this));
		listen2 = new GameListener(frame2, this);
		frame3Thread = new Thread(frame3 = new PauseMenuFrame(false));
		listen3 = new PauseMenuListener(frame3, this);

		threads.add(frame1Thread);
		threads.add(frame2Thread);
		threads.add(frame3Thread);
	
		for(Thread t: threads) t.start();
	}

	public static void main(String[] args)
	{
		new Main();
	}
}
