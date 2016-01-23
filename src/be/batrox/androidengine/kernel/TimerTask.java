package be.batrox.androidengine.kernel;

import be.batrox.androidengine.log.Logger;

public class TimerTask extends Task {

    private static float dT;
    private static long lastFrameIndex;
    private static long thisFrameIndex;

    public boolean start() {
        thisFrameIndex = System.currentTimeMillis();
        lastFrameIndex = thisFrameIndex;
        dT = 0;
        return true;
    }

    public void update() {
        lastFrameIndex = thisFrameIndex;
        thisFrameIndex = System.currentTimeMillis();
        dT = ((float)(thisFrameIndex - lastFrameIndex)) / 1000.0f;
    }

    public void stop() {
        dT = 0;
        lastFrameIndex = 0;
        thisFrameIndex = 0;
    }

    public static float getDT() {
        return dT;
    }
}
