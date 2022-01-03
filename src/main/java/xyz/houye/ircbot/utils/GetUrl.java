package xyz.houye.ircbot.utils;

public class GetUrl {
	
	/*
	 * 取到第一个网址就返回
	 */
	public static String getUrlString(String s) {
		String [] split = s.split("\\s+");
		if (split !=null && split.length != 0) {
			for (int i=0; i<split.length; i++) {
				if (split[i].startsWith("http://") || split[i].startsWith("https://"))
					return split[i];
			}
		}
		return null;
	}

}
