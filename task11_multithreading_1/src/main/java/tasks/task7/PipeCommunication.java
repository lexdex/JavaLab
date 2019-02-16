package tasks.task7;

import menu.Command;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Arrays;

public class PipeCommunication implements Command {
    private PipedWriter pw = new PipedWriter();
    private PipedReader pr = new PipedReader();
    private String[] words = "Hello, ALL! Have a Nice Day And Good Luck!".split("\\s");

    @Override
    public void execute() {
        try {
            pw.connect(pr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread reader = new Thread(this::readData);
        Thread writer = new Thread(this::writeData);
        reader.start();
        writer.start();
        try {
            reader.join();
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void readData() {
        int smb;
        char[] chs = new char[50];
        char[] word;
        try {
            smb = pr.read(chs);
            while (smb != -1) {
                word = Arrays.copyOf(chs, smb);
                System.out.println("read: " + new String(word));
                Thread.sleep(1000);
                smb = pr.read(chs);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                pr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void writeData() {
        try {
            for (String word : words) {
                pw.write(word);
                System.out.println("wrote: " + word);
                Thread.sleep(1500);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
