package utilities.selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

public class DataProvider {

	public static String getTestData(String filePath, String key) {

		Properties prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop.load(fis);
		} catch (IOException ioex) {
			ioex.printStackTrace();
			Assert.fail("FAIL| IO Exception thrown.Please check that file path is correct");
		}
		return prop.getProperty(key);
		
	}
}
