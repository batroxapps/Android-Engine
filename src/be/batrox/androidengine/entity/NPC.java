package be.batrox.androidengine.entity;

import static be.batrox.util.Utils.*;

import android.graphics.drawable.Drawable;

public class NPC extends Entity{

	public final int ALLY = 1;
	public final int NEUTRAL = 2;
	public final int ENEMY = 3;

	
	private int relationToPlayer;
	
	// sprite, speed, xPos, yPos, relationToPlayer
	public NPC(Drawable i, double xs, double ys, int x, int y, int rel){
		super(i, xs, ys, x, y);
		
		relationToPlayer = rel;
	}
	
	public void agro(){
		if (relationToPlayer == NEUTRAL)
			relationToPlayer = ENEMY;
	}

}
