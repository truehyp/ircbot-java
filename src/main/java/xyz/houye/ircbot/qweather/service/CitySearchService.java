package xyz.houye.ircbot.qweather.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import xyz.houye.ircbot.qweather.dto.CityDto;
import xyz.houye.ircbot.utils.GetProperties;
import xyz.houye.ircbot.utils.httpClient;

public class CitySearchService {
	CityDto citydto = new CityDto();
	GetProperties props = null;
	String url = null;
	String key = null;
	
	public CitySearchService() {
		this.props = new GetProperties("src/main/resources/config/app.properties");
		this.url = props.getValue("geoapi_url");
		this.key = props.getValue("key");
	}
	
	public CityDto getCityId(String location) {
		String request_url = this.url+"?location="+location+"&key="+this.key+"&number=1";
		String s = httpClient.httpGet(request_url, 2000);
		
		JSONObject jo = JSON.parseObject(s).getJSONArray("location").getJSONObject(0);
		
		if (jo != null) {
			citydto.setId(jo.getString("id"));
			citydto.setName(jo.getString("name"));
		}

		
		return  citydto;
		//return  s;
		
	}

}
