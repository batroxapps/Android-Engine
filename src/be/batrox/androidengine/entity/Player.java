package be.batrox.androidengine.entity;

import static be.batrox.util.Utils.*;

import android.graphics.drawable.Drawable;

public class Player extends Entity{

	// sprite, speed, xPos, yPos
	public Player(Drawable i, double xs, double ys, int x, int y){
		super(i, xs, ys, x, y);
	}

}
