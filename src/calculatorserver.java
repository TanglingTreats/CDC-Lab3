/*
	Code: calculator server		CalculatorServer.java

	Server code for hosting the CalculatorImpl object
*/

import java.rmi.Naming; //Import naming classes to bind to rmiregistry
import java.rmi.registry.LocateRegistry;

public class calculatorserver {
	String path_port="rmi://%s:%d/CalculatorService";
	String path="rmi://%s/CalculatorService";
	String reg_host = "192.168.1.18";
	static int port = 1099;

	// calculatorserver constructor
	public calculatorserver() {
		// Sets hostname property for rmi lookup 
		System.setProperty("java.rmi.server.hostname", reg_host);
		try {
			// Starts registry from here instead of doing it in terminal
			LocateRegistry.createRegistry(port);
			calculator c = new calculatorimpl();

			Naming.rebind(String.format(path_port, reg_host, port), c);
			System.out.println(String.format(path_port, reg_host, port));

			// Construct a new CalculatorImpl object and bind it to the local rmiregistry
			// N.b. it is possible to host multiple objects on a server
			

		} catch (Exception e) {
			System.out.println("Server Error: " + e);
		}
	}

	public static void main(String args[]) {

		// Create the new Calculator server
		if (args.length == 1)
			port = Integer.parseInt(args[0]);
		new calculatorserver();
	}
}
