/*
	Code: calculator server		CalculatorServer.java

	Server code for hosting the CalculatorImpl object
*/

import java.rmi.Naming; //Import naming classes to bind to rmiregistry
import java.rmi.registry.LocateRegistry;

public class calculatorserver {
	String path_port="rmi://%s:%d/CalculatorService";
	String path="rmi://%s/CalculatorService";
	String reg_host = "localhost";
	static int port = 1099;

	// calculatorserver constructor
	public calculatorserver() {
		System.setProperty("java.rmi.server.hostname", "192.168.1.18");
		try {
			LocateRegistry.createRegistry(port);
			calculator c = new calculatorimpl();
//			Naming.rebind(String.format(path, reg_host), c);
			Naming.rebind(String.format(path_port, reg_host, port), c);
			System.out.println(String.format(path_port, reg_host, port));
//			System.setProperty("java.security.policy", "AllPermission.policy");
//			if (System.getSecurityManager() == null) {
//				System.setSecurityManager(new SecurityManager());
//			}
			// Construct a new CalculatorImpl object and bind it to the local rmiregistry
			// N.b. it is possible to host multiple objects on a server
			

		} catch (Exception e) {
			System.out.println("Server Error: " + e);
		}
	}

	public static void main(String args[]) {
//		if (System.getSecurityManager() == null) {
//			System.setSecurityManager(new BadSecurityManager());
//			System.setProperty("java.security.policy", "AllPermission.Policy");
//		}
		// Create the new Calculator server
		if (args.length == 1)
			port = Integer.parseInt(args[0]);
		new calculatorserver();
	}
}
