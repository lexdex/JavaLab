package client_server_task;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

public class Client {

    public static void main(String[] args) throws IOException {
        InetSocketAddress address = new InetSocketAddress(Server.HOSTNAME, Server.PORT);
        SocketChannel client = SocketChannel.open(address);

        System.out.println("Connecting on port " + address.getPort());

        ArrayList<String> messages = new ArrayList<>();
        messages.add("hi");
        messages.add("exit");

        for (String message : messages) {
            sendMessage(message, client);
        }
        client.close();
    }

    private static void sendMessage(String message, SocketChannel client) throws IOException {
        byte[] messageBytes = message.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(messageBytes);
        client.write(buffer);

        System.out.println("moving it  to server: " + message);
        buffer.clear();
    }
}
