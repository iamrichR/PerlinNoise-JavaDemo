package dev.iamrichr.perlinnoise.controller;

import javafx.application.Application;
import javafx.stage.Stage;

public class Driver extends Application
{

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Controller.getInstance().start(primaryStage);
	}

	public static void main(String[] args)
	{
		Application.launch(args);
	}

}
