package fileio;

import java.io.*;
import java.util.List;

public class ReadFile<T> {
    public List<T> readToFile() {
        File file = new File("account.txt");
        try {
            InputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            List<T> t = (List<T>) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
            return t;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
