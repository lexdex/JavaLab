package comment_task.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileFinder {

    public static List<String> findLines(String fileName, String substring) {
        List<String> stringList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String line = reader.readLine();
                if (line.contains(substring)) {
                    stringList.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }
}
