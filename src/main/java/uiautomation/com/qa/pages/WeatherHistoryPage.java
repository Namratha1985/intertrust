package uiautomation.com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import uiautomation.com.qa.util.TestBase;
import uiautomation.com.qa.util.TestUtil;

public class WeatherHistoryPage extends TestBase{
	
	@FindBy(xpath = "//h3[@class='h3']")
	WebElement weatherHistory;
	
	@FindBy(xpath = "//h1")
	WebElement weatherHistoryTitle;
	
	@FindBy(className = "maingrid")
	WebElement mainGrid;
	
	//Initializing page objects
	public WeatherHistoryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String weatherDataPageTitle() {
		return weatherHistoryTitle.getText();
	}
	
	
	public boolean isWeatherHistoryDisplayed() {
		return isElementPresent(weatherHistory);
    }
	public boolean isReportDisplayed() {
		return isElementPresent(mainGrid);
    }

}
