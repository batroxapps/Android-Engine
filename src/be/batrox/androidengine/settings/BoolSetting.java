package be.batrox.androidengine.settings;

public class BoolSetting extends Setting {

    private boolean value;

    public BoolSetting(String n, boolean b) {
        super(n);

        value = b;
    }

    public boolean getValue() {
        return value;
    }
}
