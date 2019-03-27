package Denisenko.hw1.hw2;


/*
Stepic 2.2 task 2
 */

public class PowTwo {

    public static boolean isPowerOfTwo(int value ) {

        int moduleValue = Math.abs(value);
        return Integer.bitCount(value) == 1;
    }

    public static void main(String[] args) {
        isPowerOfTwo(3);
    }

}
