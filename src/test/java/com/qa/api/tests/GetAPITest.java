package com.qa.api.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import api.com.qa.base.TestBaseAPI;
import api.com.qa.client.RestClient;


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
		restClient.get(getUrl);
	}
	

}
