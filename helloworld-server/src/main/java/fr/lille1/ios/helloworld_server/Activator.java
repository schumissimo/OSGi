package fr.lille1.ios.helloworld_server;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import fr.lille1.ios.helloworld_service.api.PrintService;
import fr.lille1.ios.lib.Server;

public class Activator implements BundleActivator {

	@SuppressWarnings("rawtypes")
	private ServiceRegistration sAck;

	public void start(BundleContext context) throws Exception {
		System.out.println("Server : Bundle starts...");
		PrintService s = new Server();
		sAck = context.registerService(PrintService.class.getName(), s, null);
		System.out.println("Server : PrintService registered ...");
	}

	public void stop(BundleContext context) throws Exception {
		sAck.unregister();
		System.out.println("Server : Bundle stops...");
	}

}
