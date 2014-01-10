package fr.lille1.ios.helloworld;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import fr.lille1.ios.api.PrintService;
import fr.lille1.ios.lib.Server;

public class Activator implements BundleActivator {

	private ServiceRegistration<?> sAck;

	public void start(BundleContext context) throws Exception {
		PrintService s = new Server();
		sAck = context.registerService(Server.class.getName(), s, null);
		System.out.println("Bundle starts...");
	}

	public void stop(BundleContext context) throws Exception {
		sAck.unregister();
		System.out.println("Bundle stops...");
	}

}
