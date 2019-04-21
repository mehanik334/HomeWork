package denisenko.hw11;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String inputStr = scanner.nextLine();
        String arr[] = inputStr.split("[^A-Za-zА-Яа-я]+");
        Map<String, List<String>> groupeArray = Arrays.stream(arr).map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity()));
        groupeArray.entrySet().stream()
                .sorted((i1, i2) -> i2.getValue().size() - i1.getValue().size())
                .limit(10)
                .forEach(w -> System.out.println(w.getKey()));

    }
}
