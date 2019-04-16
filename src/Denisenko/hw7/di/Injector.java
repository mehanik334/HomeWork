package denisenko.hw7.di;


import denisenko.hw7.dao.*;
import denisenko.hw7.factory.ClientHumanDaoFactory;
import denisenko.hw7.handler.ConsoleHandler;

import java.lang.reflect.Field;

public class Injector {

    public static void injectDependency() throws IllegalAccessException {
        Class consoleHandlerClass = ConsoleHandler.class;
        Class fileClientDaoClass = FileClientDao.class;
        Class inMemoryClientDao = InMemoryClientDao.class;

        Class fileHumanDaoClass = FileHumanDao.class;
        Class inMemoryHumanDaoClass = InMemoryHumanDao.class;

        Field[] fields = consoleHandlerClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                boolean fileDao = fileClientDaoClass.isAnnotationPresent(Component.class);
                if (fileDao) {
                    System.out.println("Работа с файлами разрешена");
                }
                boolean fileHumanDao = fileHumanDaoClass.isAnnotationPresent(Component.class);
                if (fileHumanDao) {
                    System.out.println("Work with file human");
                }
                boolean inMemoryDao = inMemoryClientDao.isAnnotationPresent(Component.class);
                if (inMemoryDao) {
                    System.out.println("Работа с ОЗУ разрешена");
                }
                boolean inMemoryHumanDao = inMemoryHumanDaoClass.isAnnotationPresent(Component.class);
                if (inMemoryHumanDao) {
                    System.out.println("Work with RAM human");
                }
                if (fileDao != false && inMemoryDao != false) {
                    ClientDao clientDao = ClientHumanDaoFactory.getClientDao(fileDao, inMemoryDao);
                    field.set(null, clientDao);
                } else {
                    HumanDao humanDao = ClientHumanDaoFactory.getHumanDao(fileHumanDao, inMemoryHumanDao);
                    field.set(null, humanDao);
                }

            }
        }
    }
}
