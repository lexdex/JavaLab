package buffer_task;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {

    public static void main(String[] args) {
        try {
            File inFile = new File("test_file.txt");
            ByteBuffer buf = ByteBuffer.allocateDirect((int) inFile.length());

            InputStream is = new FileInputStream(inFile);

            int b;
            while ((b = is.read()) != -1) {
                buf.put((byte) b);
            }

            File file = new File("output_file.txt");
            FileChannel channel = new FileOutputStream(file, false).getChannel();

            buf.flip();
            channel.write(buf);

            channel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
