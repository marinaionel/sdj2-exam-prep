package sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketHandler implements Runnable {
    private Socket server;

    public ClientSocketHandler(Socket server) {
        this.server = server;
    }

    @Override
    public void run() {
        ObjectInputStream inFromServer = null;
        ObjectOutputStream outputStream = null;

        try {
            outputStream = new ObjectOutputStream(server.getOutputStream());
            inFromServer = new ObjectInputStream(server.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Type the message for the server: ");
            String message = scanner.nextLine();
            try {
                outputStream.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                System.out.println(inFromServer.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
