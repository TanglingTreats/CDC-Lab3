package rmiPerformance;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class SinkServer {
	private String path = "rmi://%s:%d/SinkService";
	private String server_host = "localhost";
	private static int server_port = 1099;

	public SinkServer() {
		// Sets hostname property for rmi lookup 
		System.setProperty("java.rmi.server.hostname", server_host);
		
		try
		{
			LocateRegistry.createRegistry(server_port);
			IntSink s = new SinkImpl();
			Naming.rebind(String.format(path, server_host, server_port), s);
			
		} catch (Exception e) {
			System.err.println("Server Error: " + e);
		}
	}

	public static void main(String[] args) {
		if (args.length == 1)
			server_port = Integer.parseInt(args[0]);
		new SinkServer();
		
	}

}
