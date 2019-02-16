package serialization.io;

import java.io.*;

public class Serialization {

    public static<T> void serialize(T object, String fileName){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static<T> T deserialize(String fileName) {
        T object = null;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            object = (T) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
