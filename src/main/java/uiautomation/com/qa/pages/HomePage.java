package uiautomation.com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import uiautomation.com.qa.util.TestBase;
import uiautomation.com.qa.util.TestUtil;

public class HomePage extends uiautomation.com.qa.util.TestBase{
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchBox;
	
	@FindBy(xpath = "//a[contains(text(),'Weather Data')]")
	WebElement weatherDataLink;
	
	//Initializing page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateVisualCrossingTitle() {
		return driver.getTitle();
	}
	
	public WeatherDataPage clickWeatherDataLink() {
		weatherDataLink.click();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		return new WeatherDataPage();
		
	}

}
