package uiautomation.com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	/**
	 * This mehtod is used to initialize the driver on the basis of given browser
	 * 
	 * @param browser
	 * @return This returns the driver
	 */
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("/Users/pradeeppalla/eclipse-workspace/VisualCrossingValidation/src/main/java/com/qa/properties/config.properties");
			prop.load(fis);
			
		}catch(IOException e) {
			e.getMessage();
		}
	}
	
	public WebDriver launchBrowser() {
		String browserName = prop.getProperty("browser");
		System.out.println("browser name is: " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			//for chrome version 116 and selenium 4.11 no need to point the chrome drover
			//System.setProperty("webdriver.chrome.driver", "/Users/pradeeppalla/Documents/chromedriver-mac-x64/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			launchUrl(prop.getProperty("url"));
			acceptCookies();
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/pradeeppalla/Downloads/geckodriver");
		
			driver = new FirefoxDriver();
		} else {
			System.out.println("please pass the correct browser: " + browserName);
		}

		return driver;
	}



	public void launchUrl(String url) {
		if (url == null) {
			System.out.println("please pass the right url");
			return;
		}
		if (url.contains("https") || url.contains("http")) {
			driver.get(url);
		} else {
			driver.close();
			try {
				throw new Exception("INVALIDURLEXCEPTION - please pass the right url");
			}
			catch(Exception e ) {
				e.printStackTrace();
			}
		}

	}
	
	public void acceptCookies() {
	  WebElement cookieDialog = driver.findElement(By.id("cookieModalLabel"));
	  new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(cookieDialog));
	  driver.findElement(By.xpath("//button[contains(text(),'Accept all cookies')]")).click();
	}

	public void launchUrl(URL url) {
		driver.navigate().to(url);
	}


	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}
	
	public boolean isElementPresent(WebElement element) {
        try {
            if (element.isDisplayed())
            	return true;

        } catch (Exception e) {
            return false;
        }
		return false;
    }



}
