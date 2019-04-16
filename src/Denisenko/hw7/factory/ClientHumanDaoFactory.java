package denisenko.hw7.factory;


import denisenko.hw7.dao.*;
import denisenko.hw7.service.PropertyLoader;

import java.io.IOException;

public class ClientHumanDaoFactory {

    private static final ClientDao inMemoryDao = new InMemoryClientDao();
    private static final ClientDao fileDao = new FileClientDao();

    private static final HumanDao inMemoryHumanDao = new InMemoryHumanDao();
    public static final HumanDao fileHumanDao = new FileHumanDao();

    public static ClientDao getClientDao(boolean isFileDao, boolean isInMemoryDao) {
        try {
            String dbName = PropertyLoader.getProperty("db.name");
            if (dbName.equals("memory") && isInMemoryDao) {
                return inMemoryDao;
            }
        } catch (IOException e) {
            System.out.println("Нет доступа к файлу");
        }
        if (isFileDao) {
            return fileDao;
        } else {
            throw new ComponentNotFoundException();
        }
    }

    public static HumanDao getHumanDao(boolean isFileDao, boolean isMemoryDao) {
        try {
            String dbName = PropertyLoader.getProperty("db.name");
            if (dbName.equals("memory") && isMemoryDao) {
                return inMemoryHumanDao;
            }
        } catch (IOException e) {
            System.out.println("No file");
        }
        if (isFileDao) {
            return fileHumanDao;
        } else {
            throw new ComponentNotFoundException();
        }
    }
}
