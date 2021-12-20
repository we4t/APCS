public class mergeTest {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*101);
        }
        printArray(array);
        System.out.println();
        MergeSort.sort(array, 1);
        printArray(array);
    }
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i] + "] ");
        }
        System.out.println();
    }
}
