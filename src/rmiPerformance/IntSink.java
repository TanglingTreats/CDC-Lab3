package rmiPerformance;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IntSink extends Remote {
	public void ignore(int localParam) throws RemoteException;

}
