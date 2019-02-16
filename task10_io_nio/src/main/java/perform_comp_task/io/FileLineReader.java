package perform_comp_task.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLineReader {

    public static String read(String fileName) {
        StringBuilder stringBuilder = null;
        try (FileReader fileReader = new FileReader(fileName)) {
            stringBuilder = new StringBuilder();
            int numCharsRead;
            char[] charArray = new char[1024];
            while ((numCharsRead = fileReader.read(charArray)) > 0) {
                stringBuilder.append(charArray, 0, numCharsRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String readBuffered(String fileName, int size) {
        StringBuilder stringBuilder = null;
        try (FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader, size)) {
            stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();

    }
}
