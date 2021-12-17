package testng.assertion;

import org.testng.annotations.Test;

public class SoftAssert {

	@Test
	public void softAssertTest() {
		org.testng.asserts.SoftAssert sf = new org.testng.asserts.SoftAssert();
		sf.assertEquals("66", "66");
		sf.assertEquals("1234567890", "1234567890");
		sf.assertEquals("teju@gmail.com", "teju1@gmail.com");
		sf.assertEquals("cse", "cse1");
		sf.assertAll();
	}

}