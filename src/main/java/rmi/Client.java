package rmi;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client implements IRemoteClient, Serializable {
    private IRemoteServer server;

    public Client() {
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry("localhost", 5000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            assert registry != null;
            server = (IRemoteServer) registry.lookup("ex");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendToClient(String text) throws RemoteException {
        System.out.println("Client new message: " + text);
    }

    private void sendToServer(String text){
        try {
            server.sendToServer(text, this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.sendToServer("Getting people to like you is only the other side of liking them.\n" +
                "—  Norman Vincent Peale");
        client.sendToServer("Happiness is a way station between too much and too little.\n" +
                "—  Channing Pollock");
        client.sendToServer("My father was an amazing man. The older I got, the smarter he got.\n" +
                "—  Mark Twain");
        client.sendToServer("The creator of the universe works in mysterious ways. But he uses a base ten counting system and likes round numbers.\n" +
                "—  Scott Raymond Adams");
        client.sendToServer("An inability to stay quiet is one of the conspicuous failings of mankind.\n" +
                "—  Walter Bagehot");
    }
}
