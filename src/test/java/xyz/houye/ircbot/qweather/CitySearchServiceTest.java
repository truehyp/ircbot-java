package xyz.houye.ircbot.qweather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import xyz.houye.ircbot.qweather.dto.CityDto;
import xyz.houye.ircbot.qweather.service.CitySearchService;

public class CitySearchServiceTest {
	
	@Test
	public void getCityIdTest() {
		CitySearchService cs = new CitySearchService();
		CityDto cd = null;
		
		cd = cs.getCityId("beij");
		assertEquals("北京", cd.getName());
		assertEquals("101010100", cd.getId());
	}

}
