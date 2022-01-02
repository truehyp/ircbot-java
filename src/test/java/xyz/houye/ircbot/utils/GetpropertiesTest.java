package xyz.houye.ircbot.utils;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;




public class GetpropertiesTest {

	GetProperties props = new GetProperties("config/app.properties");
	@Test
	public void testgetcontent() {
		//GetProperties props = new GetProperties("src/main/resources/config/app.properties");
		Map<String,String> m = new HashMap<>();
		m = props.getContent();

		assertEquals("https://devapi.qweather.com/v7/weather", m.get("qweather_url"));

	}
	
	@Test
	public void testenvkey() {
		System.out.println(props.getValue("key"));

	}


}
