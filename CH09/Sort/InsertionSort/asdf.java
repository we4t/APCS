public class asdf {
    public static void qs(int[] array, int start, int end){
        if(start >= end){
            return;
        }
        int pivot = start, i = start + 1, j = end, tmp;
        while(i <= j){
            while(i <= end && array[i] <= array[pivot]){
                i++;
            }
            while(j > start && array[j] >= array[pivot]){
                j--;
            }
            if(i > j){
                tmp = array[j];
                array[j] = array[pivot];
                array[pivot] = tmp;
            }
            else{
                tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
            }
            qs(array, start, j - 1);
            qs(array, j + 1, end);
        }
    }
}
