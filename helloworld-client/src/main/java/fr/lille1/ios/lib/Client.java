package fr.lille1.ios.lib;

import fr.lille1.ios.helloworld_service.api.PrintService;

public class Client implements Runnable {

	private PrintService service;

	public void setService(PrintService s) {
		this.service = s;
		System.out.println("Client.service = " + this.service);
	}

	public void run() {
		this.service.printMessage("Hello, world!");
	}
}