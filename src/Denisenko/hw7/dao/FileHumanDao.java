package denisenko.hw7.dao;

import denisenko.hw7.di.Component;
import denisenko.hw7.model.Human;

import java.io.*;

@Component
public class FileHumanDao implements HumanDao {


    @Override
    public void save(Human human) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("st.dat"))) {

            oos.writeObject(human);

        } catch (IOException e) {
            System.out.println("Exeption");
        }
    }

    @Override
    public Human get() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("st.dat"))) {

            return (Human) ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
