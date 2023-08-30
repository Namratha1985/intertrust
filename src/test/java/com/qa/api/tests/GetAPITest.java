package com.qa.api.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import api.com.qa.base.TestBaseAPI;
import api.com.qa.client.RestClient;
import api.com.qa.util.TestUtil;


public class GetAPITest extends TestBaseAPI{
	
	TestBaseAPI testBase;
	public String Location = "Bangalore";
	String getUrl;
	
	public GetAPITest() {
		super();
	}
	
	@BeforeMethod
	public void setuo() throws ClientProtocolException, IOException {
		testBase = new TestBaseAPI();
		getUrl = getUrl(Location);
		
	}
	@Test
	public void getAPITest() throws ClientProtocolException, IOException {
		RestClient restClient = new RestClient();
		System.out.println(getUrl);
		CloseableHttpResponse closeableHttpResponse = restClient.getCall(getUrl);
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertTrue(statusCode == 200);
	 	System.out.println("Status Code-------"+statusCode );
	 	JSONObject responseJson = restClient.getJSONResponse(closeableHttpResponse);
	 	
	 	//JSON Values Assertion 
	 	String jsonLocation = TestUtil.getValueByJPath(responseJson,"/address");
	 	Assert.assertEquals(jsonLocation, Location);
	 	String comingDaysReport = TestUtil.getValueByJPath(responseJson,"/description");
	 	
	 	System.out.println("Comingdays Report-------"+comingDaysReport );
	 	//get value from JSON Array
	 	String previousDaysTemp = TestUtil.getValueByJPath(responseJson,"/days[0]/temp");
	 	String previousDaysWeather = TestUtil.getValueByJPath(responseJson,"/days[0]/description");
	 	
	 	System.out.println("Previous Day's Temprature-------"+previousDaysTemp );
	 	System.out.println("Previous Day's WatherReport-------"+previousDaysWeather );
	 	
	}
	

}
