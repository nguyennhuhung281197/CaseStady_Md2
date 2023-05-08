package fileio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile<T> {
    public List<T> readToFile() {
        File file = new File("account.txt");
        List<T> t = new ArrayList<>();
        try ( FileInputStream inputStream = new FileInputStream(file);){

            if (inputStream.available() == 0) {
               return t;
            }else {
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                t = (List<T>) objectInputStream.readObject();
                objectInputStream.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }
//    public List<T> readFromFile() {
//        File file = new File("account.txt");
//        try {
//            InputStream inputStream = new FileInputStream(file);
//            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//            List<T> t = (List<T>) objectInputStream.readObject();
//            objectInputStream.close();
//            inputStream.close();
//            return t;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
