package client_server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {

    static final String HOSTNAME = "localhost";
    static final int PORT = 1111;

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel socket = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(HOSTNAME, PORT);

        socket.bind(address);

        socket.configureBlocking(false);

        int ops = socket.validOps();
        socket.register(selector, ops, null);

        while (true) {

            selector.select();

            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isAcceptable()) {
                    SocketChannel client = socket.accept();

                    client.configureBlocking(false);

                    client.register(selector, SelectionKey.OP_READ);
                    System.out.println("Connection Allowed " + client.getLocalAddress() + "\n");

                } else if (key.isReadable()) {

                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    client.read(buffer);
                    String result = new String(buffer.array()).trim();

                    System.out.println("All received: " + result+" with 200 code");

                    if (result.equals("close")) {
                        client.close();
                    }
                }
                iterator.remove();
            }
        }
    }
}
