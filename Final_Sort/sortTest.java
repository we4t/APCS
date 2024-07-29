public class sortTest {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 21 - i;
        }
        printArr(arr);
        mergeSort.mergSort(arr);
        printArr(arr);
    }

    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i] + "] ");
        }
        System.out.println();
    }
}
