package Denisenko.hw1.hw2;


/*
2.3
 */
public class SortUtils {



    public static void swapElements(int array[],int first,int second){

        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int[] bubbleSort(int array[]){

        for(int i = array.length - 1; i >= 1; i-- ){

            for(int j = 0; j < array.length-1; j++){

                if(array[j] > array[j + 1]){
                    swapElements(array, j, j + 1);
                }
            }
        }
        return array;
    }



    public static void main(String[] args) {

        int arr[] = {1,4,8,7};
        arr = SortUtils.bubbleSort(arr);
        for (int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
