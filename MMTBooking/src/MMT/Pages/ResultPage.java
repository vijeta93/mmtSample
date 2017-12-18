package MMT.Pages;

import org.openqa.selenium.WebDriver;

import MMT.PageLocators.ResultPageLocators;

public class ResultPage extends ResultPageLocators{
	WebDriver driver;
	public ResultPage(WebDriver driver){
		this.driver = driver;
	}

	public ResultPage searchOnlyArIndiaFlights() throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(AIR_INDIA_FLIGHTS).click();
				return this;
	}
	
	public String getPrice()
	{
		return driver.findElements(PRICE).get(0).getText();
	}
	
	public String getFlightNumber()
	{
		return driver.findElements(FLIGHT_NUMBER).get(0).getText();
	}
	
	public String getStratTime()
	{
		return driver.findElements(START_TIME).get(0).getText();
	}
}

