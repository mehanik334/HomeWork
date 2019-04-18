package denisenko.hw11;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String inputStr = scanner.nextLine();
        String[] words = inputStr.replaceAll("^[а-яА-ЯёЁa-zA-Z0-9]+$", "").toLowerCase().split("\\s+");
        Stream<String> stringStream = Arrays.stream(words);
        stringStream.distinct().limit(10).forEach(System.out::println);

    }

}
