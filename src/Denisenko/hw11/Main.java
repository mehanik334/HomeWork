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
        List<String> list = Arrays.asList(arr);
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> finalMap = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue()
                .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        int count = 0;
        for (String key : finalMap.keySet()) {
            if (count < 10) {
                count++;
                System.out.println(key);
            }
        }
    }
}
