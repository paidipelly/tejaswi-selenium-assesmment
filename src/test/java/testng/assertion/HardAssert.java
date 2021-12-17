package testng.assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	@Test
	public void hardassertTest() {
		Assert.assertEquals("Teju","Teju");
		Assert.assertEquals("66","66");
		Assert.assertEquals("1234567890","1234567890");
		Assert.assertEquals("teju@gmail.com","teju@gmail.com");
		Assert.assertEquals("cse","cse");
		
		
	}
	

}
