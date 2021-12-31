package xyz.houye.ircbot.title;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import xyz.houye.ircbot.title.service.UrlTitle;

public class UrlTitleTest {

	UrlTitle ut = new UrlTitle();

	@Test
	public void TestNull() {
		String title = ut.GetTitle("https://www.ithome.com/0/595/918.htm");
		assertNotNull(title);
	}
	@Test
	public void TestBlog() {
		String title = ut.GetTitle("https://houye.xyz");
		assertNotNull(title);
		//System.out.println(title);
	}
	
	@Test
	public void TestCsdn() {
		String title = ut.GetTitle("https://blog.csdn.net/m0_37843672/article/details/88656694");
		assertNotNull(title);
		System.out.println(title);
	}


}
