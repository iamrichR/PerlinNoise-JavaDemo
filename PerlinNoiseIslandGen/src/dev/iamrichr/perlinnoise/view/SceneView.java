package dev.iamrichr.perlinnoise.view;

import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;

public class SceneView
{
	protected Scene scene;
	protected FlowPane pane;
	protected int winWidth;
	protected int winHeight;
	protected static final int DEFAULT_WINWIDTH = 256;
	protected static final int DEFAULT_WINHEIGHT = 144;
	
	public SceneView()
	{
		this(DEFAULT_WINWIDTH, DEFAULT_WINHEIGHT);
	}
	
	public SceneView(int winWidth, int winHeight)
	{
		this.winWidth = winWidth;
		this.winHeight = winHeight;
		pane = new FlowPane();
		scene = new Scene(pane, winWidth, winHeight);
		createLayout();
	}
	
	public Scene getScene()
	{
		return scene;
	}
	
	protected void createLayout()
	{
	}
}
