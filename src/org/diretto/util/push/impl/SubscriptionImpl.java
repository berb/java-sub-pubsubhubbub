package org.diretto.util.push.impl;

import java.math.BigInteger;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.diretto.util.push.NotificationCallback;
import org.diretto.util.push.Subscriber;
import org.diretto.util.push.Subscription;

/**
 * Basic {@link Subscription} implementation. Generates a unique subscription
 * and a random verify token using a MD5 digest.
 * 
 * @author Benjamin Erb
 * 
 */
public class SubscriptionImpl implements Subscription
{
	private final URI feedUri;
	private final URI hubUri;
	private final Subscriber subscriber;
	private final String id;
	private final String verifyToken;
	private NotificationCallback notificationCallback;

	/**
	 * Creates a new subscription.
	 * @param feedUri 
	 * @param hubUri
	 * @param subscriber
	 */
	public SubscriptionImpl(URI feedUri, URI hubUri, Subscriber subscriber)
	{
		this.feedUri = feedUri;
		this.hubUri = hubUri;
		this.subscriber = subscriber;

		MessageDigest m;
		try
		{
			m = MessageDigest.getInstance("MD5");
			String s = feedUri.toString() + hubUri.toString() + subscriber.getPort();
			byte[] data = s.getBytes();
			m.update(data, 0, data.length);
			BigInteger i = new BigInteger(1, m.digest());
			this.id = String.format("%1$032x", i);

			m = MessageDigest.getInstance("MD5");
			s = feedUri.toString() + hubUri.toString() + Math.random();
			data = s.getBytes();
			m.update(data, 0, data.length);
			i = new BigInteger(1, m.digest());
			this.verifyToken = String.format("%1$032x", i);
		}
		catch (NoSuchAlgorithmException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public URI getFeedTopicUri()
	{
		return feedUri;
	}

	@Override
	public String getInternalId()
	{
		return id;
	}

	@Override
	public Subscriber getSubscriber()
	{
		return subscriber;
	}

	@Override
	public String getVerifyToken()
	{
		return verifyToken;
	}

	@Override
	public NotificationCallback getNotificationCallback()
	{
		return notificationCallback;
	}

	@Override
	public void setNotificationCallback(NotificationCallback callback)
	{
		this.notificationCallback = callback;
	}

	@Override
	public URI getHubUri()
	{
		return hubUri;
	}

}
