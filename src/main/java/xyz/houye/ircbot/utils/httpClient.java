package xyz.houye.ircbot.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class httpClient {
	private final static Logger logger = LoggerFactory.getLogger(httpClient.class);
	private static CloseableHttpClient httpclient;  
	
	static {
		httpclient = HttpClients.createDefault();
	}
	
	public static String httpGet(String url, int outTime) {
		HttpGet getmethod = new HttpGet(url);
		RequestConfig requestConfig = RequestConfig.custom().
				setConnectTimeout(outTime).setConnectionRequestTimeout(outTime)
				.setSocketTimeout(outTime).build();
		getmethod.setConfig(requestConfig);
		
		try {
			CloseableHttpResponse response = httpclient.execute(getmethod);
			HttpEntity entity = response.getEntity();
			if (entity != null){
				return EntityUtils.toString(entity,"utf-8");
			
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}

	return null;
	}
	

}
