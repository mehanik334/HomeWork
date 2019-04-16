package denisenko.hw2;


/*
Stepic 2.2 task 1
 */

public class Unicode {

    public static char charExpression(int a) {

        int numSlash = (int) '\\';
        return (char) (numSlash + a);
    }

    public static void main(String[] args) {

        System.out.println(charExpression(2));

    }
}
