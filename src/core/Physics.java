package core;

import models.Vec3D;
import ui.GameFrame;

/**
 * bunch of static methods
 * 
 * @author jtc
 *
 */
public class Physics {
	Main main;
	
	public Physics(Main m)
	{
		main = m;
	}
	
	public void putt()
	{
		Vec3D pos = main.game.ball[0],
			  vel = main.game.ball[1],
			  prevPos = null,
			  prevVel = null;
		
		// while the ball is still moving...
		while(mag(vel)>0.01) {
			double heightDiff = 0;
			if(prevPos!=null) heightDiff = pos.z - prevPos.z;
			
			// shitty cloning implementation
			prevVel = scaleVec(vel, mag(vel));
			
			vel = scaleVec(vel, mag(vel) - heightDiff);
			prevPos = scaleVec(pos, mag(pos));
			pos = scaleVec(pos, (mag(vel)*.01)+mag(pos));
			
			vel = scaleVec(vel, mag(vel)-.1);
			((GameFrame) main.frame2).canvas.update(((GameFrame) main.frame2).canvas.getGraphics());
		}
		
	}
	
	public Vec3D[] next(Vec3D pos, Vec3D vel, Vec3D acc)
	{
		Vec3D[] n = new Vec3D[3];
		
		/* where the physics happens.
		 * n[0] = position vector
		 * n[0] = velocity vector
		 * n[0] = acceleration vector
		 */
		
		return n;
	}
	
	public double mag(Vec3D v)
	{
		return Math.sqrt(v.x*v.x+v.y*v.y+v.z*v.z);
	}
	
	public Vec3D scaleVec(Vec3D v, double newMag)
	{
		double sf = newMag / mag(v);
		return new Vec3D(v.x*sf, v.y*sf, v.z*sf);
	}
}
