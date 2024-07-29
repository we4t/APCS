public class mergeSort {
    public static void mergSort(int[] arr){
        int[] result = sort(arr, 0, arr.length - 1);
        for (int i = 0; i < result.length; i++) {
            arr[i] = result[i];
        }
    }
    public static int[] merge(int[] arr1, int[] arr2){
        int[] arr = new int[arr1.length + arr2.length];
        int[] r = new int[arr.length];
        int index = 0; 
        for (int i = 0; i < arr1.length; i++) {
            arr[index] = arr1[i];
            index++;
        }
        for (int i = 0; i < arr2.length; i++) {
            arr[index] = arr2[arr2.length - 1 - i];
            index++;
        }
        int lo = 0, hi = arr.length - 1, cnt = 0;
        while(lo <= hi){
            if(arr[lo] < arr[hi]){
                r[cnt] = arr[lo];
                lo++;
                cnt++;
            }
            else{
                r[cnt] = arr[hi];
                hi--;
                cnt++;
            }
        }
        return r;
    }
    public static int[] sort(int[] arr, int lo, int hi){
        if(lo >= hi){
            return new int[] {arr[lo]};
        }
        else{
            int mid = (lo + hi) / 2;
            return merge(sort(arr, lo, mid), sort(arr, mid + 1, hi));
        }
    }


}
