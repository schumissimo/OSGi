package fr.lille1.ios.helloworld_client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import fr.lille1.ios.handler.PrintServiceHandler;
import fr.lille1.ios.helloworld_service.api.PrintService;
import fr.lille1.ios.lib.Client;

public class Activator implements BundleActivator {

	// @SuppressWarnings("rawtypes")
	// private ServiceReference[] refs;
	@SuppressWarnings("rawtypes")
	private ServiceRegistration sAck;
	private ServiceTracker serviceTracker;

	@SuppressWarnings("unchecked")
	public void start(BundleContext context) throws Exception {
		System.out.println("Client : Bundle starts ...");

		// refs = context.getServiceReferences(PrintService.class.getName(),
		// null);

		// PrintService ps = context.getService(refs[0]);
		Client client = new Client();
		// client.setService(ps);

		sAck = context.registerService(Runnable.class.getName(), client, null);
		System.out.println("Client : Client registered ...");

		ServiceTrackerCustomizer handler = new PrintServiceHandler(client);
		serviceTracker = new ServiceTracker(context,
				"fr.lille1.ios.helloworld_service.api.PrintService", handler);
		serviceTracker.open();
	}

	public void stop(BundleContext context) throws Exception {
		// refs = null;
		sAck.unregister();
		serviceTracker.close();
		System.out.println("Client : Bundle stops ...");

	}

}
