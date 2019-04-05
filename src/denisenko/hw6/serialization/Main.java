package denisenko.hw6.serialization;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Animal zoo[] = new Animal[4];
        zoo[0] = new Animal("Lion");
        zoo[0] = new Animal("Tiger");
        zoo[0] = new Animal("Elephant");
        zoo[0] = new Animal("Kengoo");

        byte[] byteZoo = null;

        try (ByteArrayOutputStream aos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(aos)) {

            oos.writeInt(zoo.length);
            for (int i = 0; i < zoo.length; i++) {
                oos.writeObject(zoo[i]);
            }
            oos.flush();
            byteZoo = aos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(zoo));
        System.out.println(Arrays.toString(byteZoo));
        Animal deserializeZoo[] = deserializeAnimalArray(byteZoo);
        System.out.println(Arrays.toString(deserializeZoo));
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {

        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int sizeArray = ois.readInt();
            Animal arr[] = new Animal[sizeArray];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (Animal) ois.readObject();
            }
            return arr;
        } catch (ClassCastException | IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException();
        }
    }

}
