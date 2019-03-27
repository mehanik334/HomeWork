package Denisenko.hw1.hw2;

/*
Stepic 2.3
 */

public class Palindrome {

    public static boolean isPalindrome ( String str ) {

        String lowerCaseStr = str.toLowerCase();
        String fixedLowCaseStr = lowerCaseStr.replaceAll("[^a-zA-Z0-9]","");
        StringBuilder stringBuilder = new StringBuilder(fixedLowCaseStr);
        StringBuilder reversSb = stringBuilder.reverse();
        return reversSb.equals(stringBuilder);
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome("Madam, I'm Adam"));

    }
}
