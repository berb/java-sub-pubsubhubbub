package org.diretto.util.push;

import com.sun.syndication.feed.synd.SyndFeed;

/**
 * This interface provides a callback method that handles incoming feed updates.
 * 
 * @author Benjamin Erb
 * 
 */
public interface NotificationCallback
{
	/**
	 * The handle method is executed each time the original feed provides
	 * updates. The parameter contains a {@link SyndFeed} with all new entries.
	 * 
	 * @param feed
	 */
	void handle(SyndFeed feed);
}
