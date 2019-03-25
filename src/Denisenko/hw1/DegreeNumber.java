package Denisenko.hw1;

import java.util.Scanner;

public class DegreeNumber {

    static double myPow(int number, int involution) {

        double answer = 1;
        if (involution < 0) {

            involution = Math.abs(involution);
            for (int i = 1; i <= involution; i++) {

                answer *= number;
            }
            return 1 / answer;

        } else if (involution == 0) {
            return answer;
        } else {

            for (int i = 1; i <= involution; i++) {

                answer *= number;
            }

        }
        return answer;

    }

    public static void main(String[] args) {

        System.out.println("Введите число");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("Введите степень,в которую возвести число");
        int inv = scanner.nextInt();
        System.out.println(myPow(num, inv));
    }

}
