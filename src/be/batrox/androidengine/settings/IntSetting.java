package be.batrox.androidengine.settings;

public class IntSetting extends Setting {

    private int value;

    public IntSetting(String n, int i) {
        super(n);

        value = i;
    }

    public int getValue() {
        return value;
    }

}
