package dev.iamrichr.perlinnoise.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MapViewer extends SceneView
{
	GraphicsContext gc;
	double[][] elevationMap;
	
	public MapViewer(double[][] map)
	{
		super();
		elevationMap = map;
	}
	
	public MapViewer(int winWidth, int winHeight, double[][] map)
	{
		super(winWidth, winHeight);
		elevationMap = map;
		drawMap();
	}
	
	public void createLayout()
	{
		Canvas canvas = new Canvas(winWidth, winHeight);
		pane.getChildren().add(canvas);
		gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	public void drawMap()
	{
		for(int i = 0; i < elevationMap.length; i++)
		{
			for(int j = 0; j < elevationMap[i].length; j++) {
				gc.setFill(Color.color(0.0, elevationMap[i][j], 0.0));
				gc.fillRect(i, j, 1, 1);
			}
		}
	}
}
