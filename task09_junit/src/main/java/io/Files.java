package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Files {

    private String fileName;

    public Files(String fileName) {
        this.fileName = fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public String readFromFile() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(
                    new FileReader(this.fileName));
        } catch (FileNotFoundException e) {
            // -
        }
        return readLines(bufferedReader);
    }

    String readLines(BufferedReader br) {
        StringBuilder stringBuffer = new StringBuilder();
        try {
            String s;
            while ((s = br.readLine()) != null) {
                stringBuffer.append(s).append("\n");
                System.out.println("while: " + s);
            }
            br.close();
        } catch (IOException ex) {
            // -
        }
        return stringBuffer.toString();
    }
}
