package xyz.houye.ircbot.utils;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class httpClientTest {
	
	@Test
	public void httpGetTest() {
		String res;
		res = httpClient.httpGet("http://baidu.com", 2000);
		
		assertNotNull(res);
	
	}
	

}
