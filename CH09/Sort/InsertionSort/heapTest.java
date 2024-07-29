public class heapTest {
    public static void main(String[] args) {
        int[] array = new int[20];
        for(int i = 0; i < array.length; i++){
            array[i] = 20-i;
        }

        printArray(array);
        HeapSort.sort(array, 1);
        printArray(array);
    }   
    public static void printArray(int[] tmp){
        for (int i = 0; i < tmp.length; i++) {
            System.out.print("[" + tmp[i] + "] ");
        }
        System.out.println();
    }
}
