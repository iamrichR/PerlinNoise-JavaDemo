package dev.iamrichr.perlinnoise.model;

public class NoiseMaker
{
	UnitVector2D[][] gradients;
	
	public NoiseMaker(UnitVector2D[][] gradients)
	{	
		this.gradients = gradients;
	}
	
	public double noise2d(double x, double y)
	{
		//define the unit square surrounding the given point
		//UNIT SQUARE
		//  U---V
		//  |   |
		//  S---T
		double x0 = Math.floor(x);
		double y0 = Math.floor(y);
		double x1 = x0 + 1;
		double y1 = y0 + 1;
		
		//get influence values for each corner point
		//TODO - probably refactor this later
		double influence_S = getInfluenceValue((int) x0, (int) y0, x, y);
		double influence_T = getInfluenceValue((int) x1, (int) y0, x, y);
		double influence_U = getInfluenceValue((int) x0, (int) y1, x, y);
		double influence_V = getInfluenceValue((int) x1, (int) y1, x, y);
		
		//get weighted and smoothed average of all influence values
		double deltaX = x - x0;
		double deltaY = y - y0;
		
		double influences_ST = lerp(influence_S,influence_T,fade(deltaX));
		double influences_UV = lerp(influence_U,influence_V,fade(deltaX));
		double influence_Avg = lerp(influences_ST,influences_UV,fade(deltaY));
		
		return influence_Avg;
	}
	
	public double getInfluenceValue(int cornerX, int cornerY, double pointX, double pointY)
	{
		//TODO - make sure this is grabbing the correct gradient
		UnitVector2D gradient = gradients[cornerX][cornerY];
		Vector2D towardsVector = getTowardsVector(cornerX, cornerY, pointX, pointY);
		return Vector2D.dotProduct(gradient, towardsVector);
	}
	
	//TODO - documentation
	//TODO - make sure this works how you think it does
	public Vector2D getTowardsVector(double cornerX, double cornerY, double pointX, double pointY)
	{
		return new Vector2D((cornerX-pointX), (cornerY-pointY));
	}
	
	//TODO - documentation
	public double lerp(double n0, double n1, double alpha)
	{
		return ((1 - alpha) * n0 + alpha * n1);
	}
	
	//TODO - see if this is too slow or not
	//TODO - documentation
	//TODO - make sure refactor'd faster version of this is working properly
	public double fade(double num) {
		return 3*num*num - 2*num*num*num;
	}
	
}
