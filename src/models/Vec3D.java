package models;

public class Vec3D {
	public double x, y, z;
	
	public Vec3D(double a, double b, double c)
	{
		x = a;
		y = b;
		z = c;
	}
	
	@Override
	public String toString()
	{
		return "<"+x+","+y+","+z+">";
	}
}
