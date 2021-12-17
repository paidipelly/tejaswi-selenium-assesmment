package testng.pckg1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Pckg1_Class1 {
  @Test
  public void testOne(){
	  System.out.println("testOne");
  }
  @Test
  public void testTwo() {
	  System.out.println("testTwo");
  }
  @Test
  public void testThree() {
	  System.out.println("testThree");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("afterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass");
  }
}
