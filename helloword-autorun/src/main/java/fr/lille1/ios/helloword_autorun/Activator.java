package fr.lille1.ios.helloword_autorun;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	@SuppressWarnings("rawtypes")
	private ServiceReference[] refs;

	public void start(BundleContext context) throws Exception {
		System.out.println("Bundle : Auto run starts");
		refs = context.getServiceReferences(Runnable.class.getName(), null);

		for (ServiceReference sr : refs) {
			new Thread((Runnable) context.getService(sr)).start();
		}
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Bundle : Auto run stops");
	}

}
