package org.diretto.util.push;

import java.net.URI;

/**
 * The Subscription interface represents a subscription to a feed using a
 * distinct hub. Note that a {@link NotificationCallback} should be set in order
 * to react on incoming updates.
 * 
 * @author Benjamin Erb
 * 
 */
public interface Subscription
{
	/**
	 * Returns the internal id of this subscription.
	 * 
	 * @return
	 */
	String getInternalId();

	/**
	 * Returns the verification token for this subscription.
	 * 
	 * @return
	 */
	String getVerifyToken();

	/**
	 * Returns the topic/feed URI this subscription is bound to.
	 * 
	 * @return
	 */
	URI getFeedTopicUri();

	/**
	 * Returns the hub URI this subscription is bound to.
	 * 
	 * @return
	 */
	URI getHubUri();

	/**
	 * Returns the corresponding {@link Subscriber}.
	 * 
	 * @return
	 */
	Subscriber getSubscriber();

	/**
	 * Sets a new {@link NotificationCallback}. If there is already callback
	 * registered, the old one will be discarded.
	 * 
	 * @param callback
	 */
	void setNotificationCallback(NotificationCallback callback);

	/**
	 * Returns the current {@link NotificationCallback} of this
	 * {@link Subscription}.
	 * 
	 * @return
	 */
	NotificationCallback getNotificationCallback();
}
