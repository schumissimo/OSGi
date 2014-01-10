package fr.lille1.ios.lib;

import fr.lille1.ios.helloworld_service.api.PrintService;

public class Server implements PrintService {

	public void printMessage(String msg) {
		System.out.println(">> " + msg);
	}

}