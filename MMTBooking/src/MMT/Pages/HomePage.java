package MMT.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MMT.PageLocators.HomePageLocators;

public class HomePage extends HomePageLocators {
	
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public HomePage searchForFlights() throws Exception
	{
		 FileInputStream fileInput = new FileInputStream(new File("C:\\Users\\vijuneja\\Desktop\\check\\Testdata.properties"));  
		 Properties prop = new Properties();   
		 prop.load(fileInput);  
		 
		driver.findElement(FLIGHTS_TAB).click();
		driver.findElement(SOURCE_CITY).sendKeys(prop.getProperty("SOURCECITY") + "\n");
		driver.findElement(DESTINATION_CITY).sendKeys(prop.getProperty("DESTINATIONCITY") + "\n");
		
		WebElement element = driver.findElement(By.cssSelector("div.ui-datepicker-group.ui-datepicker-group-last>div>a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		
		
		while(!driver.findElement(By.cssSelector(".ui-datepicker-month")).equals("JANUARY")){	
			executor.executeScript("arguments[0].click();", element);
			break;
		}
		//driver.findElement(By.cssSelector("div.ui-datepicker-group.ui-datepicker-group-last>div>a")).click();
		
		
		
		List<WebElement> allDates = driver.findElements(By.cssSelector("table.ui-datepicker-calendar>tbody>tr>td"));
		
		//allDates.get(0);
		
		for(WebElement ele:allDates)
		{	
			String date = ele.findElement(By.cssSelector("a")).getText();
			if(date.equals("1"))
			{
			ele.click();
			break;
			}	
		}
		
		driver.findElement(PASSANGER).click();
		List<WebElement> adults= driver.findElements(By.cssSelector("#js-adult_counter>li"));
		for(WebElement elemen : adults){
			String adult= elemen.getText();
			if(adult.equals("2"))
				{
				elemen.click();
				break;
				}
			
		}
		List<WebElement> children= driver.findElements(By.cssSelector("#js-child_counter>li"));
		for(WebElement elem : children){
			String child= elem.getText();
			if(child.equals("1"))
				{
				elem.click();
				break;
				}
				}
		
		driver.findElement(By.cssSelector("a.close_pax.pull-right.non-pot"));
		
		driver.findElement(CLASS).click();
		driver.findElement(By.xpath("//*[@id='js-classFilters']/div[2]/label")).click();
		driver.findElement(SEARCH_BTN).click();	
		
		return this;
		
	}

	}
