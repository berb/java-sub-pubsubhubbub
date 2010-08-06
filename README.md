# java-sub-pubsubhubbub

A straight-forward subscriber implementation written in Java for the PubSubHubBub 0.3 protocol.

## Features

This is a simple subscriber implementation written in Java that enables callback registration to feed changes. It internally uses the Apache HttpClient library for client-side requests and Eclipse Jetty as a lightweight internal webserver. For parsing Atom feeds, the ROME library is used. 

## Examples

	Subscriber subscriber = new SubscriberImpl("subscriber-host",8888);
	Subscription subscription = subscriber.subscribe(URI.create("http://feed-host/my-push-enabled-feed.xml"));

	subscription.setNotificationCallback(new NotificationCallback()
	{
	
		@Override
		public void handle(SyndFeed feed)
		{
			//TODO: Do something with the feed
		}
	} );

## Dependencies

- org.apache.httpclient + dependencies
- org.eclipse.jetty + dependencies
- ROME + dependencies

## ToDo List

The initial version only supports synchronous verification of subscription requests, asynchronous verification will be added later. The current version only supports Atom feeds.



