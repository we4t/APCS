public class selectionSort {
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int key = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < key){
                    key = arr[j];
                    index = j;
                }
            }
            int tmp = arr[index];
            arr[index] = arr[i];
            arr[i] = tmp;    
        }
    }
}
