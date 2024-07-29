public class insertionSort{
    public static void sort(int[] arr, int choice){
        if(choice % 2 == 0){
            sortWithSwap(arr);
        }
        else{
            sortWithShift(arr);
        }
    }
    public static void sortWithSwap(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if(arr[j] < arr[j - 1]){
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
                else{
                    break;
                }
            }
        }
    }
    public static void sortWithShift(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if(arr[j] > value){
                    arr[j + 1] = arr[j];
                }
                else{
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }
}