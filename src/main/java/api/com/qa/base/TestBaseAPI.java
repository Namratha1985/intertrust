package api.com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class TestBaseAPI {

	public static WebDriver driver;
	public static Properties prop;
	public static String KEY = "LB8XKDCKKPJZ246FRFHPFRY6Q";

	
	public TestBaseAPI() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("/Users/pradeeppalla/eclipse-workspace/VisualCrossingValidation/src/main/java/com/qa/properties/cofig.properties");
			prop.load(fis);

		} catch (IOException e) {
			e.getMessage();
		}
	}

	public String getUrl(String Location) {
		String baseUrl = prop.getProperty("url");
		String serviceUrl = prop.getProperty("serviceurl");
		String queryUrl = prop.getProperty("queryurl");
		String getUrl = baseUrl + serviceUrl + Location + "?unitGroup=metric&key=" + KEY+"&contentType=json"; //"https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Bangalore?unitGroup=metric&key=LB8XKDCKKPJZ246FRFHPFRY6Q&contentType=json";
		return getUrl;
	}

}
