package be.batrox.androidengine.settings;

public class FloatSetting extends Setting {

    private float value;

    public FloatSetting(String n, float f) {
        super(n);

        value = f;
    }

    public float getValue() {
        return value;
    }

}
