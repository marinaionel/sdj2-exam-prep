package sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Server started...");
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(5000);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Socket client = null;
            while (true) {
                try {
                    client = serverSocket.accept();
                    System.out.println("Client connected...");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                new Thread(new ServerSocketHandler(client)).start();
            }
        }).start();
    }
}
