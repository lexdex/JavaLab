package directory_task;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            File f = new File("."); 
            File[] files = f.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.print(" directory: ");
                    System.out.println(file.getCanonicalPath());
                } else {
                    System.out.print("file: ");
                    System.out.print(file.getCanonicalPath());
                    System.out.println(" " + file.length());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
