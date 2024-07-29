package Array.Arrays_as_Parameters.Example1;

public class Example1 {
    public static void main(String[] args) {
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        System.out.println(findMin(a));
    }
    public static int findMin(int[] arr){
        int min = arr[0];
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                minIndex = i;
                min = arr[i];
            }
        }
        return min;
    }
}
