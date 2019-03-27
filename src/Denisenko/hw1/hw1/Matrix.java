package denisenko.hw1.hw1;

public class Matrix {

    public final static int RANDOM_NUMBER = 100;

    public void fillMatrix(int array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * RANDOM_NUMBER);
            }
        }
    }

    public void showMatrix(int array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public int maxElement(int array[][], int row, int column) {

        int max = array[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    public int minElement(int array[][], int row, int column) {

        int min = array[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (min > array[i][j]) {
                    min = array[i][j];
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {

        Matrix matrix = new Matrix();
        int arr[][] = new int[3][3];
        matrix.fillMatrix(arr);
        matrix.showMatrix(arr);
        System.out.println("--------------");
        System.out.println(matrix.maxElement(arr, 3, 3));
        System.out.println("--------------");
        System.out.println(matrix.minElement(arr, 3, 3));
    }
}
