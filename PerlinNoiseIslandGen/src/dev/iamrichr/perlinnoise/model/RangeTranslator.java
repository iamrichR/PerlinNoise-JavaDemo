package dev.iamrichr.perlinnoise.model;

public class RangeTranslator
{
	public static double mapRange(double currVal, double currMin, double currMax, double newMin, double newMax) {
		double currRange = currMax - currMin;
		double newRange = newMax - newMin;
		
		return (((currVal - currMin) * newRange) / currRange) + newMin;
	}
}
