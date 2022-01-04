package xyz.houye.ircbot;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xyz.houye.ircbot.qweather.dto.CityDto;
import xyz.houye.ircbot.qweather.dto.WeatherDto;
import xyz.houye.ircbot.qweather.service.CitySearchService;
import xyz.houye.ircbot.qweather.service.WeatherForecastService;
import xyz.houye.ircbot.title.dto.UrlDto;
import xyz.houye.ircbot.title.service.UrlTitle;
import xyz.houye.ircbot.utils.GetUrl;

public class MyListener extends ListenerAdapter {
	private final Logger logger = LoggerFactory.getLogger(MyListener.class);
	@Override
	public void onGenericMessage(GenericMessageEvent event) {
		// When someone says ?helloworld respond with "Hello World"
		if (event.getMessage().startsWith("'help")) {
			event.respond("'weather cityname --> search weather");
		} else if (event.getMessage().startsWith("'weather")) {
			String location = event.getMessage().substring("'weather".length()).trim();

			if (!location.isEmpty()) {
				CitySearchService citysearchservice = new CitySearchService();
				WeatherForecastService weatherforecastservice = new WeatherForecastService();
				CityDto cd = new CityDto();
				WeatherDto wd = new WeatherDto();

				cd = citysearchservice.getCityId(location);
				if (cd != null) {
					wd = weatherforecastservice.getWealth(cd.getId(), 3);
					if (wd != null)
						event.respond(cd.getAdm2() + " " + cd.getName() + wd.toString());

				}

			}
		} else if (event.getMessage().contains("http")) {
			// 用空格分割消息，匹配网址，获取标题
			logger.info("in http");
			String urlString = GetUrl.getUrlString(event.getMessage());
			if (urlString != null && urlString.length() != 0) {
				UrlTitle ut = new UrlTitle();
				UrlDto ud = ut.GetTitle(urlString);
				if (ud.getTitle() != null && !ud.getTitle().isEmpty())
					event.respond(ud.getTitle());

			}

		}
	}

	public static void main(String[] args) throws Exception {

		// Configure what we want our bot to do
		// TODO aaa 后续把这些移到配置文件里
		Configuration configuration = new Configuration.Builder().setName("PircBotXUser2") // Set the nick of the bot.
																							// CHANGE IN YOUR CODE
				.addServer("irc.libera.chat") // Join the freenode network
				.addAutoJoinChannel("#cjlu") // Join the official #pircbotx channel
				.addListener(new MyListener()) // Add our listener that will be called on Events
				.buildConfiguration();

		// Create our bot with the configuration
		PircBotX bot = new PircBotX(configuration);
		// Connect to the server
		bot.startBot();
	}
}