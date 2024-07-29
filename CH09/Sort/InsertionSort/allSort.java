public class allSort {
    public static void selectionSort(int[] arr) {
        int key, lowest, temp;
        for (int i = 0; i < arr.length - 1; i++) // arr.length - 1 !!
        {
            key = i;
            lowest = arr[key];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < lowest) {
                    key = j;
                    lowest = arr[j];
                }
            }
            temp = arr[key];
            arr[key] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int tmp, j;
        for (int i = 1; i < arr.length; i++) {
            tmp = arr[i];
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp; // at last, there is j--
        }
    }

    public static void mergeSort(int[] array) {
        // split array into two pieces
        // mergeSort splited arraies
        // termination conition : array.length == 2 or 1
        // merge : 2 ways
        // 1. start from left
        // 2. start from left and right
        if (array.length == 1) {
            return;
        } 
        else if (array.length == 2) {
            if (array[0] > array[1]) {
                int tmp = array[0];
                array[0] = array[1];
                array[1] = tmp;
            }
        } 
        else {
            int[] arr1 = new int[array.length / 2];
            int[] arr2 = new int[array.length - array.length / 2];
            int cnt = 0;
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = array[cnt];
                cnt++;
            }
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = array[cnt];
                cnt++;
            }
            mergeSort(arr1);
            mergeSort(arr2);

            // merge two arraies
            // first solution
            int i = 0, j = 0;
            cnt = 0;
            while (i <= arr1.length - 1 && j <= arr2.length - 1) {
                if (arr1[i] < arr2[j]) {
                    array[cnt] = arr1[i];
                    cnt++;
                    i++;
                } else {
                    array[cnt] = arr2[j];
                    cnt++;
                    j++;
                }
            }
            while (i <= arr1.length - 1) {
                array[cnt] = arr1[i];
                cnt++;
                i++;
            }
            while (j <= arr2.length - 1) {
                array[cnt] = arr2[j];
                cnt++;
                j++;
            }
        }
    }

    public static void quick(int[] array){
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int start, int end){
        if(start >= end){
            return;
        }
        int i = start, j = end, pivot = end, tmp;
        while(i < j){  
            while(i < j && array[i] < array[pivot]){ //ending point
                i++;
            }
            while(j > i && array[j] >= array[pivot]){
                j--;
            }
            tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
        tmp = array[pivot];
        array[pivot] = array[j];
        array[j] = tmp; 
           
        quickSort(array, start, j - 1);
        quickSort(array, j + 1, end);
    }

    public static void heap(int[] array){
        int[] heapArr = new int[array.length + 1];
        heapArr[0] = array.length;
        int tail = array.length; // gaesoo
        for (int i = 1; i < heapArr.length; i++) {
            heapArr[i] = array[i - 1];
            upHeap(heapArr, i);
        }

        while(tail >= 1){
            array[array.length - tail] = heapArr[1];
            int tmp = heapArr[1];
            heapArr[1] = heapArr[tail];
            heapArr[tail] = tmp;
            tail--;
            downHeap(heapArr, tail, 1);
            
        }

    }

    public static void upHeap(int[] arr, int pivot){
        if(pivot <= 1){
            return;
        }
        else if(arr[pivot / 2] > arr[pivot]){
            int tmp = arr[pivot / 2];
            arr[pivot / 2] = arr[pivot];
            arr[pivot] = tmp;
            upHeap(arr, pivot / 2);
        }
    }
    
    public static void downHeap(int[] arr, int tail, int pivot){
        if(pivot * 2 > tail){
            return;
        }
        int child;
        if(pivot * 2 + 1 > tail){
            child = pivot * 2;    
        }
        else{
            if(arr[pivot * 2] < arr[pivot * 2 + 1]){
                child = pivot * 2;
            }
            else{
                child = pivot * 2 + 1;
            }
        }

        if(arr[child] < arr[pivot]){
            int tmp = arr[child];
            arr[child] = arr[pivot];
            arr[pivot] = tmp;
            downHeap(arr, tail, child);
        }
    }
}