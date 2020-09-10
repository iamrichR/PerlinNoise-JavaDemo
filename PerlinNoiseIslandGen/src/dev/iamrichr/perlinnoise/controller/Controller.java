package dev.iamrichr.perlinnoise.controller;

import dev.iamrichr.perlinnoise.model.ElevationMap;
import dev.iamrichr.perlinnoise.view.MapViewer;
import dev.iamrichr.perlinnoise.view.StartWindow;
import javafx.stage.Stage;

public class Controller
{
	private static final int winWidth = 800;
	private static final int winHeight = 600;
	private Stage stage;
	private StartWindow startWindow;
	private MapViewer mapViewer;
	private ElevationMap map;
	//private NoiseMaker noisy;
	private static Controller instance;
	
	public Controller()
	{
		startWindow = new StartWindow(winWidth,winHeight);
		map = new ElevationMap(winWidth,winHeight);
		mapViewer = new MapViewer(winWidth,winHeight,map.getElevationMap());
		//TODO - will Controller ever need NoiseMaker or should it be created in the generateMap method?
		//noisy = new NoiseMaker(map.getGradients());
	}
	
	public static Controller getInstance()
	{
		if(instance == null)
		{
			instance = new Controller();
		}
		
		return instance;
	}
	
	/*public NoiseMaker getNoiseMaker()
	{
		return noisy;
	}*/
	
	public void start(Stage stage)
	{
		this.stage = stage;
		showStartupWindow();
	}
	
	public void showStartupWindow()
	{
		stage.setScene(startWindow.getScene());
		stage.show();
	}
	
	public void showMapViewer()
	{
		stage.setScene(mapViewer.getScene());
		stage.show();
	}
}
