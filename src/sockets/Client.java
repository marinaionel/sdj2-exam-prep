package sockets;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            ClientSocketHandler clientSocketHandler = new ClientSocketHandler(socket);
            new Thread(clientSocketHandler).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
