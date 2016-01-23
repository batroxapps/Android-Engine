package be.batrox.androidengine.kernel;

import be.batrox.androidengine.profiler.Profiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kernel {
    private Kernel() {}

    private static List<Task> taskList = new ArrayList<Task>();
    private static List<Task> pausedTaskList = new ArrayList<Task>();

    public static int execute(){
        init();
        Profiler p = new Profiler();


        while (taskList.size() > 0){
        p.startTimer("Main loop");
            for (Task t : taskList) {
                if (!t.canKill)
                    t.update();
            }

            ArrayList<Integer> toKill = new ArrayList<Integer>();
            for (Task t : taskList) {
                if (t.canKill) {
                    toKill.add(taskList.indexOf(t));
                    t.stop();
                }
            }

            for (int i = toKill.size() - 1; i >= 0; i--)
                taskList.remove(i);

            Logger.logDebug("Loop done!");
            p.stopTimer();
        }


        p.printData("Main loop");

        return 0;
    }

    private static void init() {

    }

    public static boolean addTask(Task t) {
        if (!t.start())
            return false;

        taskList.add(t);
        sortTaskList();

        return true;
    }

    public static void suspendTask(Task t) {
        if (taskList.contains(t)) {
            t.onSuspend();
            taskList.remove(taskList.indexOf(t));
            pausedTaskList.add(t);
        }
    }

    public static void resumeTask(Task t) {
        if (pausedTaskList.contains(t)) {
            t.onResume();
            pausedTaskList.remove(pausedTaskList.indexOf(t));
            taskList.add(t);
            sortTaskList();
        }
    }

    public static void removeTask(Task t) {
        if (taskList.contains(t))
            t.canKill = true;
    }

    public static void killAllTasks() {
        for (Task t : taskList)
            t.canKill = true;
    }

    private static void sortTaskList() {
        Collections.sort(taskList);
    }
}
