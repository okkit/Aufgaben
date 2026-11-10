package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class KBProperties extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String URL;
	private static String USER;
	private static String PASSWORD;

	public static String getURL() {
		if (URL == null)
			readProperties();
		return URL;
	}
	public static String getUser() {
		if (USER == null)
			readProperties();
		return USER;
	}

	public static String getPass() {
		if (PASSWORD == null)
			readProperties();
		return PASSWORD;
	}
	
	private static void readProperties() {

		String path = "klassenbuch.properties";

		Properties appProps = new Properties();
		try {
			appProps.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		URL = appProps.getProperty("url");
		USER = appProps.getProperty("user");
		PASSWORD = appProps.getProperty("pass");
	}

}
