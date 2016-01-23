package be.batrox.androidengine;

import static be.batrox.util.Utils.*;

import be.batrox.androidengine.screen.Screen;

import android.app.Activity;

import android.content.Intent;

import android.opengl.GLSurfaceView;

import java.util.ArrayList;

public class Engine{
	
	private static GLSurfaceView activeScreen;
	private static boolean running = false;
	
	private static GameThread gameThread;
	
	private static Screen screenActivity;
	
	public static void init(){
		// start Screen activity
		
	}
	
	public static void startTimer(){
		running = true;
		
		write("running");
		
		// start game thread
		gameThread = new GameThread();
		new Thread(gameThread).start();
	}
	
	public static void setScreenActivity(Screen a){
		gameThread.setScreenActivity(a);
	}
	
	public static Screen getScreenActivity(){
		return gameThread.getScreenActivity();
	}
	
	public static void pauseTimer(){
		running = false;
		
		write("stopped");
	}
	
	public static boolean isRunning(){
		return running;
	}
	
	public static void activateScreen(GLSurfaceView screen){
		activeScreen = screen;
		
		gameThread.activateScreen(screen);
	}
	
	public static GLSurfaceView getActiveScreen(){
		return activeScreen;
	}
}
