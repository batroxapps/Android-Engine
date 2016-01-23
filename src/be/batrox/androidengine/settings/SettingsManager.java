package be.batrox.androidengine.settings;

import java.util.HashMap;
import java.util.Map;

public class SettingsManager {

    private static Map<String, Setting> settings = new HashMap<String, Setting>();

    private SettingsManager() {} // Uninstansiable class

    public static void addSetting(Setting s) {
        settings.put(s.getName(), s);
    }

    public static Setting getSetting(String s) {
        return settings.get(s);
    }
}
