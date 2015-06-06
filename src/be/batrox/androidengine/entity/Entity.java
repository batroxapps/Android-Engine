package be.batrox.androidengine.entity;

import be.batrox.androidengine.screen.Screen;

import android.graphics.drawable.Drawable;

public abstract class Entity{
	
	private Drawable sprite;
	private double speed;
	
	public Entity(Drawable i, double s){
		sprite = i;
		speed = s;
	}
}
