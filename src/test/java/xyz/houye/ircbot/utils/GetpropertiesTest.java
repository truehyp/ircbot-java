package xyz.houye.ircbot.utils;



import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;




public class GetpropertiesTest {

	@Test
	public void testgetcontent() {
		//GetProperties props = new GetProperties("src/main/resources/config/app.properties");
		GetProperties props = new GetProperties("config/app.properties");
		Map<String,String> m = new HashMap<>();
		m = props.getContent();
		String s = props.getValue("qweather_url");

		assertEquals("https://devapi.qweather.com/v7/weather", m.get("qweather_url"));
		assertEquals("https://devapi.qweather.com/v7/weather", s);

	}


}
