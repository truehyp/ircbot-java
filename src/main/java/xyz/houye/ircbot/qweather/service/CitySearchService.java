package xyz.houye.ircbot.qweather.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import xyz.houye.ircbot.qweather.dto.CityDto;
import xyz.houye.ircbot.utils.GetProperties;
import xyz.houye.ircbot.utils.httpClient;

public class CitySearchService {
	private final Logger logger = LoggerFactory.getLogger(CitySearchService.class);

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
		logger.info("qweather resp: "+s);
		
		if ( ! "200".equals(JSONObject.parseObject(s).getString("code"))){
			return null;
		}
		
		JSONObject jo = JSON.parseObject(s).getJSONArray("location").getJSONObject(0);
		
		if (jo != null) {
			citydto.setId(jo.getString("id"));
			citydto.setName(jo.getString("name"));
			citydto.setAdm2(jo.getString("adm2"));
		}
		logger.info("citydto:"+citydto.toString());
		return  citydto;
		//return  s;
		
	}

}
