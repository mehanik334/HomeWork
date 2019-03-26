package Denisenko.hw1;

public class Recursion {


    //факториал числа рекурсией
    static int factorial(int num) {

        if (num == 1) {
            return 1;
        }
        num *= factorial(num - 1) ;
        return num;

    }

    //число Фибонначи рекурсией
    static int myFibonachi(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else {
            int answer = myFibonachi(n - 2) + myFibonachi(n - 1);
            return answer;
        }

    }

    //Ряд Тейлора
    static double rowTaylor(int a, int b) {
        if (a == 0) {
            return 0;
        } else {
            double answer = (Math.pow(-1, a) / factorial(a * 2)) * Math.pow(b, 2 * a) + rowTaylor(a - 1, b);
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(2));
        System.out.println(myFibonachi(3));
        System.out.println(rowTaylor(2, 2));
    }


}
