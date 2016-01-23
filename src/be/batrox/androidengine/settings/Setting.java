package be.batrox.androidengine.settings;

public abstract class Setting {

    protected String name;

    public Setting(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

}
