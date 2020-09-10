package dev.iamrichr.perlinnoise.model;

public class UnitVector2D extends Vector2D
{

	public UnitVector2D(double x, double y)
	{
		super(convertToUnitVector(x,y));
	}
	
	public UnitVector2D(Vector2D origVector) {
		this(origVector.getX(),origVector.getY());
	}
	
	private static double[] convertToUnitVector(double origX, double origY) {
		Vector2D origVector = new Vector2D(origX, origY);
		double vectorLength =  origVector.getLength();
		double unitX = origX / vectorLength;
		double unitY = origY / vectorLength;
		return new double[]{unitX, unitY};
	}

}
