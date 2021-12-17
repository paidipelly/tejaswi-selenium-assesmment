package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotations {

@Test(priority=1)
public void testOne(){
	  System.out.println("Annotation_testOne");
}
@Test(priority=2,dependsOnMethods="testOne")
public void testTwo() {
	  System.out.println("Annotation_testTwo");
}
@Test(priority=3,dependsOnMethods="testOne")
public void testThree() {
	  System.out.println("Annotation_testThree");
}
@BeforeMethod
public void beforeMethod() {
	  System.out.println("Annotation_beforeMethod");
}

@AfterMethod
public void afterMethod() {
	  System.out.println("afterMethod");
}

@BeforeClass
public void beforeClass() {
	  System.out.println("Annotation_beforeClass");
}
@AfterClass
public void afterClass() {
	  System.out.println("Annotation_afterClass");
}





}

