package api.com.qa.client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	//GET Method
	public void get(String url) throws ClientProtocolException, IOException {
		 	CloseableHttpClient httpclient = HttpClients.createDefault();
		 	HttpGet httpget = new HttpGet(url);
		 	CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpget); //hit the GET URL
		 	int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		 	System.out.println("Status Code-------"+statusCode );
		 	String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UFT-8");
		 	JSONObject responseJson = new JSONObject(responseString);
		 	
	}

}
