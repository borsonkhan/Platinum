package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

	public  String getProperty(String key) {
		String value = null;

		Properties prop = loadProperty("testRun");

		value = prop.getProperty(key);

		if (value == null) {

			String testEnv = prop.getProperty("testEnv");

			prop = loadProperty(testEnv);

			System.out.println(prop);
			value = prop.getProperty(key);
		}

		return value;
	}

	/// for soucelabs property
	public String getSaucelabsProperty(String key) {
		String value = null;

		Properties prop = loadProperty("Saucelabs");

		value = prop.getProperty(key);

		return value;
	}

	// for loadProperty
	private Properties loadProperty(String propFileName) {
		Properties prop = new Properties();

		String filePath = ".\\src\\main\\resources\\properties\\" + propFileName.trim() + ".properties";

		try {
			File file = new File(filePath);
			FileInputStream fileStream = new FileInputStream(file);
			prop.load(fileStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
	}

}
