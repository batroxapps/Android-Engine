package be.batrox.androidengine.entity;

import be.batrox.androidengine.screen.Screen;

import android.graphics.drawable.Drawable;

public abstract class Entity{
	
	private Drawable sprite;
	private double xSpeed;
	private double ySpeed;
	
	private int xPos;
	private int yPos;
	
	public Entity(Drawable i, double xs, double ys, int x, int y){
		sprite = i;
		xSpeed = xs;
		ySpeed = ys;
	}
	
	public int getXPos(){
		return xPos;
	}
	
	public int getYPos(){
		return yPos;
	}
	
	public synchronized void draw(long timeDifference){
		move(timeDifference);
	}
	
	private void move(long timeDifference){
		xPos += timeDifference * xSpeed;
		yPos += timeDifference * ySpeed;
	}
}
