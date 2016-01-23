package be.batrox.androidengine.settings;

public class StringSetting extends Setting {

    private String value;

    public StringSetting(String n, String s) {
        super(n);

        value = s;
    }

    public String getValue() {
        return value;
    }

}
