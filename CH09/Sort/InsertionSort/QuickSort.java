public class QuickSort {
    public static int sortOrder;

    public static void sort(int[] arr, int order) {
        sortOrder = order;
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = end, tmp;
        while (i < j) {
            while (i < j && arr[i] < arr[pivot]) {
                i++;
            }
            while (j > i && arr[j] >= arr[pivot]){
                j--;
            }
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        tmp = arr[pivot];
        arr[pivot] = arr[j];
        arr[j] = tmp;
        quickSort(arr, start, j -1);
        quickSort(arr, j + 1, end);
    }   

    public static boolean compare(int x, int y) {
        if (sortOrder == 1) {
            return x <= y;
        } else {
            return x > y;
        }
    }
}