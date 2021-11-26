package sockets;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable {
    private Socket client;

    public ServerSocketHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;

        try {
            outputStream = new ObjectOutputStream(client.getOutputStream());
            inputStream = new ObjectInputStream(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                //message to MD5
                outputStream.writeUTF("Thank you client for the message \"" + DigestUtils.md5Hex(inputStream.readUTF()) + "\".");
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
