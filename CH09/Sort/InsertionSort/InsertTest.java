public class InsertTest {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(200 * Math.random());
        }
        printArray(arr);
        insertionsort.sort(arr, 1);
        printArray(arr);
    }

    public static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print("[" + i + "] ");
        }
        System.out.println();

    }
}
