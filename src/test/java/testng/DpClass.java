package testng;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DpClass {
	@Test(dataProvider="data-provider")
	public void dataProviderTest(String input) {
		System.out.println("Name is"+input);
		
	}
	@DataProvider(name="data-provider")
	public Object[][]dpMethod(){
		return new Object[][] {
			{"Teju"},
			{"Rohith"},
			{"pallavi"},
		};
			
		
		}
	@DataProvider(name="data-provider-1")
	public Object[][]dpMethod1(){
		return new Object[][] {
			{"1,2"},
			{"2,3"},
			{"4,5"},
		};
			
	}
}


