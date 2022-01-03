package xyz.houye.ircbot.title.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.houye.ircbot.title.dto.UrlDto;
import xyz.houye.ircbot.utils.httpClient;

public class UrlTitle {
	private final Logger logger = LoggerFactory.getLogger(UrlTitle.class);
	
	public UrlDto GetTitle(String url) {
		logger.info("in GetTitle url"+url);
		Pattern p = Pattern.compile("<title>(.*)</title>");
		String title;
		Matcher m; 
		UrlDto ud = new UrlDto();

		ud.setUrl(url);

		String resp = httpClient.httpGet(url, 5000);
		//logger.info("resp: "+resp);
		m=p.matcher(resp);
		if (m.find()) {
			title =  m.group().replace("<title>", "").replace("</title>", "").trim();
			if ( !title.isEmpty())
				ud.setTitle(title);
			return ud;
		}

		return null;

		//String[] arr = resp.split("\\<title\\>(.*)\\</title\\>");
		
		//return arr;
		
	}

}
