package xyz.houye.ircbot.title;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import xyz.houye.ircbot.title.dto.UrlDto;
import xyz.houye.ircbot.title.service.UrlTitle;

public class UrlTitleTest {

	UrlTitle ut = new UrlTitle();

	@Test
	public void TestNull() {
		UrlDto ud  = ut.GetTitle("https://www.ithome.com/0/595/918.htm");
		assertNotNull(ud.getTitle());
	}
	@Test
	public void TestBlog() {
		UrlDto ud  = ut.GetTitle("https://houye.xyz");
		assertNotNull(ud.getTitle());
		//System.out.println(title);
	}
	
	@Test
	public void TestCsdn() {
		UrlDto ud  = ut.GetTitle("https://blog.csdn.net/m0_37843672/article/details/88656694");
		assertNotNull(ud.getTitle());
		System.out.println(ud.getTitle());
	}


}
