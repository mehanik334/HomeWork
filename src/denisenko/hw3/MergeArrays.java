package denisenko.hw3;

public class MergeArrays {

    public static int[] mergeTwoArrays(int[] arrayOne, int[] arrayTwo) {

        int[] resArray = new int[arrayOne.length + arrayTwo.length];
        int indArrOne = 0;
        int indArrTwo = 0;

        for (int i = 0; i < resArray.length; i++) {

            if (indArrOne > arrayOne.length - 1) {

                resArray[i] = arrayTwo[indArrTwo];
                indArrTwo++;

            } else if ((indArrTwo > arrayTwo.length - 1) || (arrayOne[indArrOne] < arrayTwo[indArrTwo])) {

                resArray[i] = arrayOne[indArrOne];
                indArrOne++;

            } else {

                resArray[i] = arrayTwo[indArrTwo];
                indArrTwo++;

            }
        }
        return resArray;
    }


    public static void main(String[] args) {

        int[] ar1 = {0};
        int[] ar2 = {3, 4};
        int[] res = mergeTwoArrays(ar1, ar2);
        for (int i = 0; i < res.length; i++) {

            System.out.println(res[i]);

        }
    }
}
