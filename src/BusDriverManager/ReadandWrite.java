package BusDriverManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadandWrite {

    public static <T> List<T> read(String file) {
        List<T> list = new ArrayList<>();
        try (ObjectInputStream o = new ObjectInputStream(new FileInputStream(file))) {
            list = (List<T>) o.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static <T> void write(String file, List<T> list) {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file))) {
            o.writeObject(list);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}