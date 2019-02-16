package command;

import java.util.HashMap;
import java.util.Map;

public class FileOperationExecutor {

    private Map<String, FileOperation> fileOperations = new HashMap<>();

    public void addOperation(String operationName, FileOperation fileOperation) {
        fileOperations.put(operationName, fileOperation);
    }
    public void performOperation(String operationName, String fileName) {
        fileOperations.entrySet().stream().filter(e -> e.getKey().equals(operationName))
                .map(Map.Entry::getValue).findFirst().ifPresent((e) -> e.perform(fileName));
    }
}
