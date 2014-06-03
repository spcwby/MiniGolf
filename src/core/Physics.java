package core;

import models.Vec3D;

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
}
