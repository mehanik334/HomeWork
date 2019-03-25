package Denisenko.hw1;

import java.util.Scanner;

public class PariMatch {


    static int basedMatch(int firstTeam, int secondTeam, int matchFirst, int matchSecond) {

        return ((firstTeam == matchFirst) && (secondTeam == matchSecond)) ? 2 :
                (((firstTeam > secondTeam) && (matchFirst > matchSecond)) ||
                        ((secondTeam > firstTeam) && (matchSecond > matchFirst)) ? 1 : 0);
    }

    public static void main(String[] args) {
        System.out.println("Введите результат и то что поставил пользователь . Пример 0,2,1,1");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String arr[] = s.split(",");
        int result = basedMatch(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]), Integer.valueOf(arr[2]), Integer.valueOf(arr[3]));
        System.out.println(result);
    }

}
