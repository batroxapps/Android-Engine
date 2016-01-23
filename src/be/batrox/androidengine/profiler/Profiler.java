package be.batrox.androidengine.profiler;

import be.batrox.androidengine.log.Logger;
import java.util.HashMap;
import java.util.Map;

public class Profiler {
    private long beginTime = 0;
    private Map<String, CodeBlock> codeBlocks = new HashMap<String, CodeBlock>();
    private String currentName = "";
    private boolean running;

    public void startTimer(String name) {
        if (running) {
            Logger.logError("Profiler is already running! Name of code block: " + currentName);
            System.exit(1);
        }

        if (!codeBlocks.containsKey(name))
            codeBlocks.put(name, new CodeBlock(name));

        currentName = name;
        running = true;

        beginTime = System.currentTimeMillis();
    }

    public long stopTimer() {
        long totalTime = System.currentTimeMillis() - beginTime;

        if (!running) {
            Logger.logError("Profiler is not running!");
            System.exit(2);
        }

        running = false;

        codeBlocks.get(currentName).addTime(totalTime);

        // Logger.logDebug("Size: " + codeBlocks.size());

        return totalTime;
    }

    public long getMinimum(String n) {
        return codeBlocks.get(n).getMinimum();
    }

    public long getMaximum(String n) {
        return codeBlocks.get(n).getMaximum();
    }

    public long getAverage(String n) {
        return codeBlocks.get(n).getAverage();
    }

    public int getCalls(String n) {
        return codeBlocks.get(n).getCalls();
    }

    public void printData(String n) {
        codeBlocks.get(n).printData();
    }

}
