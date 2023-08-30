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

	// GET Method
	public CloseableHttpResponse getCall(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		return httpclient.execute(httpget); // hit the GET URL

	}

	public JSONObject getJSONResponse(CloseableHttpResponse closeableHttpResponse)
			throws ClientProtocolException, IOException {
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
		JSONObject responseJson = new JSONObject(responseString);
		return responseJson; // hit the GET URL

	}
}
