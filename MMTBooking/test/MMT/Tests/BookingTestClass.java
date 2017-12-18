package MMT.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import MMT.Commons.Common;
import MMT.Pages.HomePage;
import MMT.Pages.ResultPage;

public class BookingTestClass {
	
	
	
	@Test
	
	public void test_SearchFlights() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijuneja\\Desktop\\check\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Common.URL.MMT_HOME);
		new HomePage(driver).searchForFlights();
		new ResultPage(driver).searchOnlyArIndiaFlights();
		
		String flightnumber= new ResultPage(driver).getFlightNumber();
		String price = new ResultPage(driver).getPrice();
		String starttime = new ResultPage(driver).getStratTime();
		
		Reporter.log("Cheapest flight Details: Flight Number is: " +flightnumber +",  Price: " +price  +", Start Time: " +starttime );
	driver.close();
	}
	
}
