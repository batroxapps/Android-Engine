package be.batrox.androidengine.screen;

import static be.batrox.util.Utils.*;

import be.batrox.androidengine.Engine;
import be.batrox.androidengine.entity.*;

import android.app.Activity;

import android.opengl.GLSurfaceView;

import android.os.Bundle;

import java.util.ArrayList;

public abstract class Screen extends Activity
{
	// GLSurfaceView where everything is drawn upon
	private GLSurfaceView surfView;
	
	// entities on screen
	private Player player;
	private ArrayList<NPC> NPCs = new ArrayList<NPC>();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    
	public void loadSurfaceViews(){}
    
    public synchronized void draw(long timeDifference){
		player.draw(timeDifference);
		for (NPC npc : NPCs){
			npc.draw(timeDifference);
		}
	}
	
	public void setGLSurfaceView(GLSurfaceView view){
		setContentView(view);
	}
}
