package dev.iamrichr.perlinnoise.model;

public class ElevationMap
{
	//TODO - should this be a Singleton?
	private int mapWidth;
	private int mapHeight;
	private double[][] elevations;
	private UnitVector2D[][] gradients;
	//TODO - move the next 3 variables to RangeTranslator
	private double translatedWidth;
	private double translatedHeight;
	private double stepValue = 0.01;
	
	public ElevationMap(int mapWidth, int mapHeight)
	{	
		this.mapWidth = mapWidth;
		this.mapHeight = mapHeight;
		translatedWidth = mapWidth*stepValue;
		translatedHeight = mapHeight*stepValue;
		gradients = generateGradientValues();
		elevations = generateMap();
	}
	
	private UnitVector2D[][] generateGradientValues()
	{
		UnitVector2D[][] gradients = new UnitVector2D[((int) translatedWidth) + 1][((int) translatedHeight) + 1];
		
		for(int i = 0; i < gradients.length; i++)
		{
			for(int j = 0; j < gradients[i].length; j++) {
				gradients[i][j] = new UnitVector2D(Vector2D.getRandomVector());
			}
		}
		
		return gradients;
	}
	
	public double[][] getElevationMap()
	{
		return elevations;
	}
	
	private double[][] generateMap()
	{
		double[][] noiseMap = new double[mapWidth][mapHeight];
		NoiseMaker noisy = new NoiseMaker(gradients);
		double noiseVal = 0.0;
		double minVal = Double.MAX_VALUE;
		double maxVal = -100;
		double mappedVal = 0.0;
		System.out.println("Starting noise gen");
		for(int x = 0; x < mapWidth; x++)
		{
			for(int y = 0; y < mapHeight; y++) {
				noiseVal = noisy.noise2d(x*stepValue, y*stepValue);
				mappedVal = RangeTranslator.mapRange(noiseVal, -0.56, 0.62, 0.07, 0.93);
				noiseMap[x][y] = mappedVal;
				//System.out.printf("(%f, %f): %f\n",x*stepValue,y*stepValue,mappedVal);
				if(Double.compare(mappedVal, minVal) < 0) {
					//System.out.printf("MIN: (%d, %d):  %f\n",x,y,mappedVal);
					minVal = mappedVal;
				}
				if(Double.compare(mappedVal, maxVal) > 0) {
					//System.out.printf("MAX: (%d, %d):  %f\n",x,y,mappedVal);
					maxVal = mappedVal;
				}
			}
		}
		
		System.out.println("Noise Gen complete");
		System.out.printf("MAX:  %f\n",maxVal);
		System.out.printf("MIN:  %f\n",minVal);
		
		return noiseMap;
	}
}
