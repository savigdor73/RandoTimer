package com.randotimer;

import org.apache.wicket.Component;
import org.apache.wicket.event.Broadcast;

public class ComponentsNotifier {
	private Component sender;
	private Component [] receiver;
	
	public ComponentsNotifier(Component sender, Component [] receiver) {
		this.sender = sender;
		this.receiver = receiver;
	}
	
	public void sendEvents(ComponentEvent event) {
		for (int i=0; i < receiver.length; i++) {
			sender.send(receiver[i], Broadcast.EXACT, event);
		}
	}
}
