package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteClient extends Remote {
    void sendToClient(String text) throws RemoteException;
}
