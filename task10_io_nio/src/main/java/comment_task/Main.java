package comment;

import comment.io.FileFinder;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> comments = FileFinder.findLines(args[0], "//");
        System.out.println(comments);
    }
}
