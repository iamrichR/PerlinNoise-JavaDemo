package dev.iamrichr.perlinnoise.model;

import java.util.Random;

//class represents a vector in 2D space
public class Vector2D
{
	protected double x;
	protected double y;
	
	public Vector2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector2D(double[] xy)
	{
		this.x = xy[0];
		this.y = xy[1];
	}
	
	public double[] getVector()
	{
		return new double[]{x,y};
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public double getLength() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	//TODO - useful method comment
	public static double dotProduct(Vector2D vec1, Vector2D vec2)
	{
		return (vec1.getX() * vec2.getX() + vec1.getY() * vec2.getY());
	}
	
	public static Vector2D getRandomVector()
	{
		Random rng = new Random();
		//TODO - do the cos(rand) random angle thing later
		double initialX = (rng.nextDouble()*2) - 1;
		double initialY = (rng.nextDouble()*2) - 1;
		return new Vector2D(initialX, initialY);
	}
	
	public String toString()
	{
		return String.format("(%f, %f) len: %f", x, y, this.getLength());
	}
	
}
