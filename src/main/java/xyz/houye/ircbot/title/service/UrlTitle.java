package xyz.houye.ircbot.title.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import xyz.houye.ircbot.title.dto.UrlDto;
import xyz.houye.ircbot.utils.httpClient;

public class UrlTitle {
	
	public String GetTitle(String url) {
		Pattern p = Pattern.compile("<title>(.*)</title>");
		Matcher m; 
		UrlDto ud = new UrlDto();

		ud.setUrl(url);

		String resp = httpClient.httpGet(url, 5000);
		m=p.matcher(resp);
		if (m.find()) {
			return m.group().replace("<title>", "").replace("</title>", "").trim();
		}

		return null;

		//String[] arr = resp.split("\\<title\\>(.*)\\</title\\>");
		
		//return arr;
		
	}

}