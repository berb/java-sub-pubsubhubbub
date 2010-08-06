package org.diretto.util.push;

import java.net.URI;

/**
 * The subscriber interface. This interface is the basic interface of a
 * subscriber in the context of the PubSubHubBub protocol. This also includes an
 * embedded webserver for incoming notifications.
 * 
 * It allows the subscription and unsubscription of feed URIs. Each subscription
 * creates a {@link Subscription} object, where a callback should be defined.
 * 
 * @author Benjamin Erb
 * 
 */
public interface Subscriber
{
	/**
	 * Subscribe to a new feed. Note that the feed must be a
	 * PubSubHubBub-enabled feed, thus it must contain a link pointing to its
	 * hub.
	 * 
	 * @param feedTopicUri
	 *            the feed to subscribe
	 * @return a {@link Subscription} object for this subscription
	 */
	Subscription subscribe(URI feedTopicUri);

	/**
	 * Cancels an existing {@link Subscription}. This includes the
	 * unsubscription at the corresponding hub.
	 * 
	 * @param subscription
	 */
	void unsubscribe(Subscription subscription);

	/**
	 * Returns the port this subscriber is listening to.
	 * 
	 * @return
	 */
	int getPort();

	/**
	 * Returns the hostname this subsriber is externally accessible.
	 * 
	 * @return
	 */
	String getHost();

	/**
	 * Returns the {@link Subscription} of the given id.
	 * 
	 * @param id
	 * @return
	 */
	Subscription getSubscriptionById(String id);

	/**
	 * Verify a subscription intent. This method can be used to answer a
	 * verification message by the hub. If there is a known intent for
	 * subscribing feed, it will return true.
	 * 
	 * @param feedTopicUri
	 * @param verifyToken
	 * @return
	 */
	boolean verifySubscribeIntent(URI feedTopicUri, String verifyToken);

	/**
	 * Registers a subscription intent.
	 * 
	 * @param feedTopicUri
	 * @param verifyToken
	 */
	void addSubscribeIntent(URI feedTopicUri, String verifyToken);

	/**
	 * Removes a subscription intent.
	 * 
	 * @param feedTopicUri
	 * @param verifyToken
	 */
	void removeSubscribeIntent(URI feedTopicUri, String verifyToken);

	/**
	 * Verify a unsubscription intent. This method can be used to answer a
	 * verification message by the hub. If there is a known intent for
	 * unsubscribing feed, it will return true.
	 * 
	 * @param feedTopicUri
	 * @param verifyToken
	 * @return
	 */
	boolean verifyUnsubscribeIntent(URI feedTopicUri, String verifyToken);

	/**
	 * Registers a unsubscription intent.
	 * 
	 * @param feedTopicUri
	 * @param verifyToken
	 */
	void addUnsubscribeIntent(URI feedTopicUri, String verifyToken);

	/**
	 * Remove a unsubscription intent.
	 * 
	 * @param feedTopicUri
	 * @param verifyToken
	 */
	void removeUnsubscribeIntent(URI feedTopicUri, String verifyToken);

	/**
	 * Dispatches and executes a runnable. This method is used for invoking
	 * callbacks without blocking threads of the webserver.
	 * 
	 * @param runnable
	 */
	void executeCallback(Runnable runnable);
}
