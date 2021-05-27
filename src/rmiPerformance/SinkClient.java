package rmiPerformance;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class SinkClient {
	private static String path = "rmi://%s:%d/SinkService";
	private static String server_host = "localhost";
	private static int server_port = 1099;
	
	public SinkClient() {
		
	}

	public static void main (String[] args) {

		if (args.length == 1) {
			server_port = Integer.parseInt(args[0]);
		} else if (args.length == 2) {
			server_host = args[0];
			server_port = Integer.parseInt(args[1]);
		}

		try
		{
			IntSink s = (IntSink) Naming.lookup(String.format(path, server_host, server_port));

		}
		catch (MalformedURLException murle) {
			System.out.println();
			System.out.println("MalformedURLException");
			System.out.println(murle);
		} catch (RemoteException re) {
			System.out.println();
			System.out.println("RemoteException");
			System.out.println(re);
		} catch (NotBoundException nbe) {
			System.out.println();
			System.out.println("NotBoundException");
			System.out.println(nbe);
		} catch (java.lang.ArithmeticException ae) {
			System.out.println();
			System.out.println("java.lang.ArithmeticException");
			System.out.println(ae);
		}
		
	}

}
