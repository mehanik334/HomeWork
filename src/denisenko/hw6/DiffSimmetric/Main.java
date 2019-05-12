package denisenko.hw6.DiffSimmetric;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<String> first = new HashSet<>();
        first.add("1");
        first.add("9");
        first.add("8");
        first.add("6");

        Set<String> second = new HashSet<>();
        second.add("1");
        second.add("9");
        second.add("6");
        second.add("1");

        System.out.println("First set  - " + first);
        System.out.println("Second set  - " + second);
        System.out.println("Differnce - " + symmetricDifference(first, second));

    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> firstSet = new HashSet<>(set1);
        Set<T> secondSet = new HashSet<>(set2);
        firstSet.removeAll(set2);
        secondSet.removeAll(set1);
        firstSet.addAll(secondSet);
        return firstSet;

    }
}
