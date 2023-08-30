package com.qa.uiautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uiautomation.com.qa.pages.HomePage;
import uiautomation.com.qa.pages.WeatherDataPage;
import uiautomation.com.qa.pages.WeatherHistoryPage;
import uiautomation.com.qa.util.TestBase;

public class WeatherReportTest extends TestBase {

	HomePage homePage;
	public String location = "Bangalore";

	public WeatherReportTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		launchBrowser();
		homePage = new HomePage();
	}

	@Test
	public void weatherReportOfLocation() {
		String homePageTitle = homePage.getPageTitle();
		WeatherDataPage weatherDataPage = homePage.clickWeatherDataLink();
		Assert.assertEquals(homePageTitle,"Weather Data & Weather API | Visual Crossing");
		System.out.println("HomePage Title: " + homePageTitle);
	    weatherDataPage = homePage.clickWeatherDataLink();
		String weatherDataPageTitle = weatherDataPage.getPageTitle();
		Assert.assertEquals(weatherDataPageTitle,"Historical Weather Data & Weather Forecast Data | Visual Crossing");
		System.out.println("Weather Data Title: " + weatherDataPageTitle);
		WeatherHistoryPage weatherHistoryPage = weatherDataPage.search(location);
		Assert.assertTrue(weatherHistoryPage.isWeatherHistoryDisplayed(),"Report is Not Loaded for "+ location);
		Assert.assertEquals(weatherHistoryPage.weatherDataPageTitle(), "Historical weather data for Bangalore");
		System.out.println("Historical Weather Data: " + weatherHistoryPage.weatherDataPageTitle());
		
	}
	
	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}

}
