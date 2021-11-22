package rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements IRemoteServer {
    public Server() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendToServer(String text, IRemoteClient client) throws RemoteException {
        System.out.println("Server new message: " + text);
        client.sendToClient("Thank you, client " + client.hashCode());
    }

    public static void main(String[] args) {
        Registry registry = null;
        try {
            registry = LocateRegistry.createRegistry(5000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        IRemoteServer server = new Server();
        try {
            assert registry != null;
            registry.bind("ex", server);
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
        System.out.println("Server started...");
    }
}
