package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Pckg2_Class2 {
  @Test(priority=1,groups={"regression"})
  public void testOne(){
	  System.out.println("testOne");
  }
  @Test(priority=2,groups={"regression","smoke"})
  public void testTwo() {
	  System.out.println("testTwo");
  }
  @Test(priority=3,groups={"smoke"})
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
