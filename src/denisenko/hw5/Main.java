package denisenko.hw5;

public class Main {

    public static void main(String[] args) {

        MyHashMap<String, Integer> bankVault = new MyHashMap<>();
        bankVault.put("Sasha D", 123);
        bankVault.put("Alena Ch", 456);
        bankVault.put("Lidia M", 789);
        System.out.println(bankVault);
        System.out.println(bankVault.get("Sasha D"));
        System.out.println(bankVault.remove("Alena Ch"));


    }
}
