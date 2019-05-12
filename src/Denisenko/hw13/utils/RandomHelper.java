package denisenko.hw13.utils;

import java.util.Random;

public class RandomHelper {

    public static String getRandomStrFrom4Digit() {
        Random random = new Random();
        String rand = String.valueOf(random.nextInt(9999 - 1000 + 1) + 1000);
        return rand;
    }
}
