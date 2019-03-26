package Denisenko.hw1;

public class RombusPainter {


    public void drawRombus(int maxLongLineLenght) {

        int a = 1;
        for (int i = 0; i < maxLongLineLenght / 2 + 1; i++) {

            helperDraw(maxLongLineLenght, a);
            a = a + 2;
        }
        a = maxLongLineLenght - 2;
        for (int i = maxLongLineLenght / 2; i > 0; i--) {

            helperDraw(maxLongLineLenght, a);
            a = a - 2;
        }
    }

    public void helperDraw(int lenght, int argument2) {

        int prob = (lenght - argument2) / 2;

        for (int j = 0; j < prob; j++) {
            System.out.print("-");
        }
        for (int k = 0; k < argument2; k++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
