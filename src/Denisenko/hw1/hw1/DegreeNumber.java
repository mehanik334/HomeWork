package Denisenko.hw1.hw1;

import java.util.Scanner;

public class DegreeNumber {

    public static double helper(int invol,int num,double ans){

        for (int i = 1; i <= invol; i++) {

              ans*= num;
        }
        return ans;
    }

    static double myPow(int number, int involution) {

        double answer = 1;
        if (involution < 0) {

            try {
                int moduleInvolution = Math.abs(involution);
                return 1 / helper(moduleInvolution,number,answer);
            }catch (NullPointerException e){
                System.out.println("Error!!!");
            }

        } else if (involution == 0) {
            return answer;
        } else {

            answer = helper(involution,number,answer);
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
