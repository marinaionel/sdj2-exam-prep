package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteServer extends Remote {
    void sendToServer(String text, IRemoteClient client) throws RemoteException;
}
