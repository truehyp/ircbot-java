package xyz.houye.ircbot.qweather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import xyz.houye.ircbot.qweather.service.WeatherForecastService;

public class WeatherForecastTest {
	WeatherForecastService w = new WeatherForecastService();

	@Test
	public void getWealth3d() {
		//assertEquals("https://devapi.qweather.com/v7/weather", w.url);
		assertNotNull(w.getWealth("101010100", 0));
		System.out.println(w.getWealth("101010100",3).toString()
				);
	}

}
