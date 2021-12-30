package xyz.houye.ircbot.qweather.service;

import com.alibaba.fastjson.JSONObject;

import xyz.houye.ircbot.utils.GetProperties;
import xyz.houye.ircbot.utils.httpClient;

public class WeatherForecastService {
	
	GetProperties props = null;
	String url = null;
	String key = null;
	
	public WeatherForecastService() {
		this.props = new GetProperties("src/main/resources/config/app.properties");
		this.url = props.getValue("qweather_url");
		this.key = props.getValue("key");
		
	}
	/*
	 * location_id 地区的码值
	 * day 天数，从今天开始算
	 */
	public JSONObject getWealth(String location_id, int day) {
		String request_url = this.url+"/3d"+"?location="+location_id+"&key="+this.key;
		String s = httpClient.httpGet(request_url, 2000);
		JSONObject jo = null;
		jo = JSONObject.parseObject(s);
		return jo;
	}

}
