package testng.pckg1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Pckg1_Class2 {
	@Test(priority=1)
	  public void testOne(){
		  System.out.println("Annotation2_testOne");
	  }
	  @Test(priority=2)
	  public void testTwo() {
		  System.out.println("Annotation2_testTwo");
	  }
	  @Test(priority=3)
	  public void testThree() {
		  System.out.println("Annotation2_testThree");
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("Annotation2_beforeMethod");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("Annotation2_afterMethod");
	  }
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Annotation2_beforeClass");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("Annotation2_afterClass");
	  }
}
