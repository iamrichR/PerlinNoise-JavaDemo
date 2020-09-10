package dev.iamrichr.perlinnoise.view;

import dev.iamrichr.perlinnoise.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class StartWindow extends SceneView
{
	Button startButton;
	
	public StartWindow()
	{
		super();
	}
	
	public StartWindow(int winWidth, int winHeight)
	{
		super(winWidth, winHeight);
	}
	
	protected void createLayout()
	{
		startButton = new Button("Start");
		startButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event)
			{
				//TODO - make this a lambda expression
				Controller.getInstance().showMapViewer();
			}
		});
		pane.getChildren().add(startButton);
	}
}
