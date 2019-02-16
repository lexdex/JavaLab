package command;

public class TextFile {

    public void create(String fileName) {
        System.out.println("File " + fileName + " created");
    }

    public void open(String fileName) {
        System.out.println("File " + fileName + " opened");
    }

    public void save(String fileName) {
        System.out.println("File " + fileName + " saved");
    }

    public void delete(String fileName) {
        System.out.println("File " + fileName + " deleted");
    }
}
