package uiautomation.com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import uiautomation.com.qa.util.TestBase;
import uiautomation.com.qa.util.TestUtil;

public class WeatherDataPage extends TestBase{
	@FindBy(id = "wxlocation")
	WebElement enterLocation;
	
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement searchBtn;	

	@FindBy(xpath = "//h3/a[@class='dropdown-toggle']")
	WebElement locationDetails;
	
	@FindBy(xpath = "//h3[@class='h3']")
	WebElement weatherHistory;
	
	@FindBy(className = "maingrid")
	WebElement mainGrid;
	
	//Initializing page objects
	public WeatherDataPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String weatherDataPageTitle() {
		return driver.getTitle();
	}
	
	public WeatherHistoryPage search(String Location){
		enterLocation.sendKeys(Location);
		searchBtn.click();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		return new WeatherHistoryPage();
	}
	
}
