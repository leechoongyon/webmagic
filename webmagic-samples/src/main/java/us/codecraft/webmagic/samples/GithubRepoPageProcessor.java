package us.codecraft.webmagic.samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author code4crafter@gmail.com <br>
 * @since 0.5.1
 */
public class GithubRepoPageProcessor implements PageProcessor
{

	private Site site = Site.me().setRetryTimes(3).setSleepTime(0);

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void process(Page page)
	{
		logger.info("page : [{}]", page);
	}

	@Override
	public Site getSite()
	{
		return site;
	}

	public static void main(String [] args)
	{
		Spider.create(new GithubRepoPageProcessor())
			  .addUrl ("http://finance.naver.com/")
			  .thread(5)
			  .run();
	}
}
