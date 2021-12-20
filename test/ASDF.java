public class sorrrtttt{
    public static void selectionSort(int[] array){
        int key, lowest;
        for (int i = 0; i < array.length - 1; i++) {
            key = i;
            lowest = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < lowest){
                    key = j;
                    lowest = array[j];
                }
            }
            array[i] = array[key];
            array[key] = lowest;
        }
    }

    public static void insertionSort(int[] array){
        int i, j;
        for (i = 1; i < array.length; i++) {
            key = array[i];
            for (j = i - 1; j >= 0; j--) {
                if(array[j] > key){
                    array[j+1] = array[j];
                }
                else{
                    break;
                }
            }
            array[j + 1] = key; 
        }
    }

    public static void mergeSort(int[] array){
        if(array.length == 1){
            return;
        }
        else if(array.length == 2){
            if(array[0] > array[1]){
                int tmp = array[0];
                array[0] = array[1];
                array[1] = tmp;
            }
        }
        else{
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
            int i = 0, j = 0;
            cnt = 0;
            while(i < arr1.length && j < arr2.length){
                if(arr1[i] < arr2[j]){
                    array[cnt] = arr1[i];
                    i++;
                    cnt++;
                }
                else{
                    array[cnt] = arr2[j];
                    j++;
                    cnt++;
                }
            }
            while(i < arr1.length){
                array[cnt] = arr1[i];
                i++;
                cnt++;
            }
            while(j < arr2.length){
                array[cnt] = arr2[j];
                    j++;
                    cnt++;
            }
        }
    }

    public static void quickSort(int[] array, int start, int end){
        int pivot = end, i = start, j = end - 1, tmp;
        while(i <= j){
            while(i <= end - 1 && array[i] <= array[pivot]){
                i++;
            }
            while(j >= start && array[j] >= array[pivot]){
                j--;
            }
        }
    }
}