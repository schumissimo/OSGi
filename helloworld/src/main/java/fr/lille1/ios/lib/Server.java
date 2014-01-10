package fr.lille1.ios.lib;

import fr.lille1.ios.api.PrintService;

public class Server implements PrintService {

	public void printMessage(String msg) {
		System.out.println(">> " + msg);
	}

}