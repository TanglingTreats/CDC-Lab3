package rmiPerformance;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IntSink extends Remote {
	/**
	 * Single method with single int argument used to time RMI calls
	 * 
	 * @param localParam
	 * @throws RemoteException
	 */
	public void ignore(int localParam) throws RemoteException;

}
