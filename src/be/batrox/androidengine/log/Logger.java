package be.batrox.androidengine.log;

import be.batrox.androidengine.R;

import android.util.Log;

public class Logger {

    private static final String TAG = "Engine";

    private static final int ERROR = 0;
    private static final int WARN = 1;
    private static final int INFO = 2;
    private static final int DEBUG = 3;
    private static final int VERBOSE = 4;

    private static void log(int level, String s) {
        switch (level) {
            case ERROR:
                Log.e(TAG, s);
                break;
            case WARN:
                Log.w(TAG, s);
                break;
            case INFO:
                Log.i(TAG, s);
                break;
            case DEBUG:
                Log.d(TAG, s);
                break;
            case VERBOSE:
                Log.v(TAG, s);
                break;
        }

    }

    public static void logError(String s) {
        log(ERROR, s);
    }

    public static void logWarn(String s) {
        log(WARN, s);
    }

    public static void logInfo(String s) {
        log(INFO, s);
    }

    public static void logDebug(String s) {
        log(DEBUG, s);
    }

    public static void logVerbose(String s) {
        log(VERBOSE, s);
    }
}
