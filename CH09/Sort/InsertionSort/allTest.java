public class allTest {
    public static void main(String[] args) {
        int[][] arr = new int[5][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[20];
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = (int) (Math.random() * 101);
            }
        }
        printArr(arr);
        System.out.println();
        allSort.selectionSort(arr[0]);
        allSort.insertionSort(arr[1]);
        allSort.mergeSort(arr[2]);
        allSort.quick(arr[3]);
        allSort.heap(arr[4]);
        printArr(arr);

    }

    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print("[" + arr[i][j] + "] ");
            }

            System.out.println();
        }
    }
}
