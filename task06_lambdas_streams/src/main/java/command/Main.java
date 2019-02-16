package command;


import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in, "UTF-8");
    private static FileOperationExecutor fileOperationExecutor = new FileOperationExecutor();
    private static TextFile textFile = new TextFile();

    public static void main(String[] args) {

        fileOperationExecutor.addOperation("Create",new CreateFileOperation(textFile));
        fileOperationExecutor.addOperation("Open", e -> textFile.open(e));
        fileOperationExecutor.addOperation("Save", new FileOperation() {
            @Override
            public void perform(String fileName) {
                textFile.save(fileName);
            }
        });
        fileOperationExecutor.addOperation("Delete", textFile::delete);

        String requestedOperation = sc.nextLine();
        String requestedFile = sc.nextLine();

        fileOperationExecutor.performOperation(requestedOperation, requestedFile);

    }
}
