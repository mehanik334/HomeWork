package Denisenko.hw1.hw1;

import java.util.Scanner;

public class DegreeNumber {

    static double myPow(int number, int involution) {

        double answer = 1;
        int moduleInvolution = Math.abs(involution);

        for (int i = 1; i <= moduleInvolution; i++) {

            if (involution < 0) {
                answer*=number;
                if(i == moduleInvolution){
                    answer=1/answer;
                }
            } else if (involution == 0) {
                return answer;
            } else {
                answer *= number;
            }
        }
        
        return answer;

    }

    public static void main(String[] args) {

        System.out.println("Enter number");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("Enter the degree to which the number should be raised.");
        int inv = scanner.nextInt();
        System.out.println(myPow(num, inv));
    }

}
