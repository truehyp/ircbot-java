package xyz.houye.ircbot.utils;

import org.junit.Test;

public class GetUrlTest {
	
	@Test
	public void TestgetUrl() {
		String arr = GetUrl.getUrlString("aaa https://baidu.com  bbb ccc ddd");
		if (arr != null&& arr.length() !=0) {
				System.out.println("###"+arr+"###");
		}
		
	}

}
