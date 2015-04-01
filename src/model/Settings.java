package model;

import io.FileHandler;

import java.util.HashMap;
import java.util.Map;

import util.AppUtil;

public class Settings {
	private static Map<String, String> preferences = new HashMap<>();

	public static void setPreference(String name, String value) {
		if (preferences.isEmpty()) {
			loadPreference();
		}
		preferences.put(name, value);
		savePreferences();
	}

	public static String getPreference(String name) {
		if (preferences.isEmpty()) {
			loadPreference();
		}
		return preferences.get(name);
	}

	private static void loadPreference() {
		FileHandler.cacheCSVMapping(FileHandler.parseCSV(AppUtil
				.mergeFolderAndFileName(AppConstants.preferenceFile,
						AppConstants.configDir)), preferences);
	}

	private static void savePreferences() {
		FileHandler.flushCSVMapping(preferences, new String[] { "PreferenceName",
				"Value" }, AppUtil.mergeFolderAndFileName(
				AppConstants.preferenceFile, AppConstants.configDir));
	}

}
