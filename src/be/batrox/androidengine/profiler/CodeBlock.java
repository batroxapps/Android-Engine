package be.batrox.androidengine.profiler;

import be.batrox.androidengine.kernel.Logger;

import java.util.ArrayList;
import java.util.List;

public class CodeBlock {

    private String name;
    private List<Long> times = new ArrayList<Long>();
    private long maximum = 0;
    private long average = 0;
    private long minimum = 0;

    public CodeBlock(String n) {
        name = n;
    }

    public void addTime(long t) {
        times.add(t);

        Logger.logInfo("Time: " + t);

        if (t > maximum || maximum == 0) {
            maximum = t;
            Logger.logInfo("Bigger: " + t);
        }

        if (t < minimum || minimum == 0){
            minimum = t;
            Logger.logInfo("Smaller: " + t);
        }

        calculateAverage();

        Logger.logDebug("# of times: " + times.size());
    }

    private void calculateAverage() {
        average = 0;

        for (int i = 0; i < times.size(); i++)
            average += times.get(i);

        average /= times.size();
    }

    /*
    *	###########
    * 	# GETTERS #
    *  	###########
    */

    public long getMinimum() {
        return minimum;
    }

    public long getMaximum() {
        return maximum;
    }

    public long getAverage() {
        return average;
    }

    public void printData() {
        Logger.logInfo("Performance of " + name + ": \n\tMinimum: " + minimum + "\n\tMaximum: " + maximum + "\n\tAverage: " + average);
    }

}
