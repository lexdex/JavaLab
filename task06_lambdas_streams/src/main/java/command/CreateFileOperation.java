package command;

public class CreateFileOperation implements FileOperation{

    private TextFile textFile;

    public CreateFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public void perform(String fileName) {
        this.textFile.create(fileName);
    }
}
