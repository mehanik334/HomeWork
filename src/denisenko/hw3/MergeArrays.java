package denisenko.hw3;

public class MergeArrays {

    public static int[] mergeTwoArrays(int[] arrayOne, int[] arrayTwo) {

        int[] newArray = new int[arrayOne.length + arrayTwo.length];
        int k = 0;
        for (int i = 0; i < arrayOne.length; i++) {

            for (int j = 0; j < arrayTwo.length; j++) {

                if ((arrayOne.length == 1) && (arrayOne[0] < arrayTwo[0]) && (arrayTwo.length == 1)) {

                    newArray[newArray.length - 2] = arrayOne[0];
                    newArray[newArray.length - 1] = arrayTwo[0];

                }else if (arrayOne[i] < arrayTwo[j]) {

                    newArray[i + j + k] = arrayOne[i];
                    arrayOne = removeFistItem(arrayOne);
                    k++;
                    i--;
                    break;

                } else {

                    newArray[i + j + k] = arrayTwo[j];
                    arrayTwo = removeFistItem(arrayTwo);

                    if (arrayTwo.length == 0) {

                        for (int g = k + 1, h = 0; g < newArray.length; g++, h++) {
                            newArray[g] = arrayOne[h];
                        }
                    }
                    j--;
                    k++;

                }

            }

        }
        return newArray;
    }

    private static int[] removeFistItem(int[] ar) {

        int[] result = new int[ar.length - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = ar[i + 1];
        }
        return result;
    }

    public static void main(String[] args) {

        int[] ar1 = {1, 5, 7, 12};
        int[] ar2 = {0, 1, 7};
        int[] res = mergeTwoArrays(ar1, ar2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
