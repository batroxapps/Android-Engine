package be.batrox.androidengine.profiler;

import be.batrox.androidengine.log.Logger;

import java.util.ArrayList;
import java.util.List;
import static be.batrox.util.Utils.*;

public class CodeBlock {

    private String name;
    private List<Long> times = new ArrayList<Long>();
    private long minimum = 0;
    private long maximum = 0;
    private double average = 0;

    public CodeBlock(String n) {
        name = n;
    }

    public void addTime(long t) {
        times.add(t);

        if (t > maximum || maximum == 0)
            maximum = t;

        if (t < minimum || minimum == 0)
            minimum = t;

        calculateAverage();
    }

    private void calculateAverage() {
        average = 0;

        for (int i = 0; i < times.size(); i++)
            average += (double) times.get(i);

        average /= (double) times.size();
        average = roundDouble(average, 5);
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

    public double getAverage() {
        return average;
    }

    public int getCalls() {
        return times.size();
    }

    public void printData() {
        Logger.logInfo("Performance of " + name + ": \n\tMinimum: " + minimum + "\n\tMaximum: " + maximum + "\n\tAverage: " + average);
    }



}
