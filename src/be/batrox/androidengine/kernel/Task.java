package be.batrox.androidengine.kernel;

public abstract class Task implements Comparable {

    protected boolean canKill;
    private long priority;

    public abstract boolean start();
    public void onSuspend(){}
    public abstract void update();
    public void onResume(){}
    public abstract void stop();

    public long getPriority() {
        return priority;
    }

    public int compareTo(Object otherTask) throws ClassCastException {
        if (!(otherTask instanceof Task))
            throw new ClassCastException("Not a task!");

        return (int) (this.priority - ((Task)otherTask).getPriority());
    }

}
