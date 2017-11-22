package us.codecraft.webmagic.samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class NaverPageProcessor implements PageProcessor
{
	private Site site = Site.me().setRetryTimes(3).setSleepTime(0);

	private Logger logger = LoggerFactory.getLogger(NaverPageProcessor.class);
	
	@Override
	public void process(Page page)
	{
		// TODO Auto-generated method stub
		logger.info("page : [{}]", page.getHtml());
	}


	@Override
	public Site getSite()
	{
		return site;
	}
	
	public static void main(String [] args)
	{
		Spider.create(new NaverPageProcessor())
			  .addUrl("http://cafe.naver.com/joonggonara")
			  .thread(5)
			  .run();
	}

}
