package fr.lille1.ios.handler;

import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import fr.lille1.ios.lib.Client;

public class PrintServiceHandler implements ServiceTrackerCustomizer {

	private Client client;

	public PrintServiceHandler(Client client) {
		this.client = client;
	}

	public Object addingService(ServiceReference arg0) {
		System.out.println(arg0 + " is added");
		return null;
	}

	public void modifiedService(ServiceReference arg0, Object arg1) {
		System.out.println(arg0 + " is modified");

	}

	public void removedService(ServiceReference arg0, Object arg1) {
		System.out.println(arg0 + " is removed");

	}

}
