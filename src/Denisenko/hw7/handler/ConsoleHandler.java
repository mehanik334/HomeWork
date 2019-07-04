package denisenko.hw7.handler;


import denisenko.hw7.dao.ClientDao;
import denisenko.hw7.dao.HumanDao;
import denisenko.hw7.di.Inject;
import denisenko.hw7.model.Client;
import denisenko.hw7.model.Human;

import java.util.Scanner;

public class ConsoleHandler {

    @Inject
    private static ClientDao clientDao;
    @Inject
    private static HumanDao humanDao;

    static public void handle() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - если вносите клиента, 2 - если получаете клиента," +
                    "3 - если вносите человека , 4 - если получаете человека , 5 - для выхода");
            int consoleChoice = scanner.nextInt();
            switch (consoleChoice) {
                case 1:
                    addClientInfo(scanner);
                    break;
                case 2:
                    System.out.println(clientDao.get());
                    break;
                case 3:
                    addHumanInfo(scanner);
                    break;
                case 4:
                    System.out.println(humanDao.get());
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void addClientInfo(Scanner scanner) {
        System.out.println("Введите информацию о клиенте");
        System.out.println("Введите имя");
        String name = scanner.next();
        System.out.println("Введите телефон");
        String phone = scanner.next();
        Client client = new Client(name, phone);
        clientDao.save(client);
    }

    private static void addHumanInfo(Scanner scanner) {
        System.out.println("Введите информацию о человеке");
        System.out.println("Введите рост");
        int height = scanner.nextInt();
        System.out.println("Введите вес");
        int weight = scanner.nextInt();
        Human human = new Human(height, weight);
        humanDao.save(human);
    }


}
