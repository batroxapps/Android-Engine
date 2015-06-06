package be.batrox.androidengine;

import be.batrox.androidengine.screen.Screen;

import java.util.ArrayList;

public class Engine{
	
	private ArrayList<Screen> screens = new ArrayList<Screen>();
	private boolean isRunning = false;
	
	public Engine(){
		
	}
	
	public void startTimer(){
		isRunning = true;
		
		// start game thread
	}
	
	public void pauseTimer(){
		isRunning = false;
	}
	
	public boolean isRunning(){
		return isRunning;
	}
}
