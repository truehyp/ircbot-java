package xyz.houye.ircbot.qweather.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import xyz.houye.ircbot.qweather.dto.WeatherDto;
import xyz.houye.ircbot.utils.GetProperties;
import xyz.houye.ircbot.utils.httpClient;

public class WeatherForecastService {
	private final Logger logger = LoggerFactory.getLogger(WeatherForecastService.class);
	
	GetProperties props = null;
	String url = null;
	String key = null;
	
	public WeatherForecastService() {
		this.props = new GetProperties("config/app.properties");
		this.url = props.getValue("qweather_url");
		this.key = props.getValue("key");
		
	}
	/*
	 * location_id 地区的码值
	 * day 天数，从今天开始算,暂时写死明天
	 */
//	public JSONObject getWealth(String location_id, int day) {
//		String request_url = this.url+"/3d"+"?location="+location_id+"&key="+this.key;
//		String s = httpClient.httpGet(request_url, 2000);
//		JSONObject jo = null;
//		jo = JSONObject.parseObject(s);
//		return jo;
//	}
	public WeatherDto getWealth(String location_id, int day) {
		String request_url = this.url+"/3d"+"?location="+location_id+"&key="+this.key;
		String s = httpClient.httpGet(request_url, 2000);
		logger.info("qweather resp: "+s);
		JSONArray ja = null;
		WeatherDto wd = new WeatherDto();

		if ( ! "200".equals(JSONObject.parseObject(s).getString("code"))){
			return null;
		}

		ja = JSONObject.parseObject(s).getJSONArray("daily");
		wd.setfxDate(ja.getJSONObject(1).getString("fxDate"));
		wd.setTempMax(ja.getJSONObject(1).getString("tempMax"));
		wd.setTempMin(ja.getJSONObject(1).getString("tempMin"));
		wd.setTextDay(ja.getJSONObject(1).getString("textDay"));
		wd.setTextNight(ja.getJSONObject(1).getString("textNight"));
		wd.setWindDirDay(ja.getJSONObject(1).getString("windDirDay"));
		wd.setWindDirNight(ja.getJSONObject(1).getString("windDirNight"));
		wd.setWindScaleDay(ja.getJSONObject(1).getString("windScaleDay"));
		wd.setWindScaleNight(ja.getJSONObject(1).getString("windScaleNight"));
		
		logger.info(wd.toString());

		return wd;
	}

}
