package core;

import java.util.ArrayList;

import models.Vec3D;

public class GameData {
	public int[] scoreCard = new int[9];
	public static int[] parCard = {2, 2, 2, 2, 2, 2, 2, 2, 3};
	public static final int BALL_RADIUS = 6;
	
	// what is a ball but position,
	// velocity, and acceleration vectors?
	public Vec3D position = new Vec3D(30, 100, 0),
				 velocity = new Vec3D(30, 30, 0),
				 acceleration = new Vec3D(30, 30, 0);
	public Vec3D[] ball = {position, velocity, acceleration};

	public double angle = 7*Math.PI/4, power = 40.0;
	public int holeNumber = 0, shotsTaken = 0;
	
	Main main;
	
	public GameData(Main m)
	{
		main = m;
	}
	
	public ArrayList<String> stats()
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("hole: "+holeNumber);
		list.add("par: "+parCard[holeNumber]);
		list.add("shots: "+ shotsTaken);
		list.add("angle: "+angleInDegrees()+" degrees");
		list.add("power: "+power);
		list.add("ball x coordinate: "+ball[0].x);
		list.add("ball y coordinate: "+ball[0].y);
		return list;
	}
	
	private int angleInDegrees() {
		return (int) (360 - angle*360/(2*Math.PI));
	}
	
	public void reset()
	{
		angle = 0.0;
		power = 10.0;
		int i = scoreCard.length;
		scoreCard = new int[i];
	}

}
