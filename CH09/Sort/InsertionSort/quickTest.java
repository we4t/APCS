public class quickTest {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 20);
        }   
        printArray(arr);
        QuickSort.sort(arr, 1);
        printArray(arr);
    }
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i] + "] ");
        }
        System.out.println();
    }
    
}
