package be.batrox.androidengine;

import be.batrox.androidengine.screen.Screen;

import android.opengl.GLSurfaceView;

public class GameThread implements Runnable{
	
	private static Screen screenActivity;

	public void run(){
		long startTime = System.currentTimeMillis();
		long lastTime = System.currentTimeMillis();
		while(Engine.isRunning()){
			long timeDifference = System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();
			
			//~ screenActivity.draw(timeDifference);
		}
	}
	
	public void setScreenActivity(Screen a){
		screenActivity = a;
	}
	
	public Screen getScreenActivity(){
		return screenActivity;
	}
	
	public static void activateScreen(GLSurfaceView screen){
		screenActivity.setGLSurfaceView(screen);
	}
	
}
