public class Example2 {
    public static void main(String[] args) {
        int[] a = new int[40];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        printArr(a);
        changeEven(a);
        printArr(a);

    }   
    public static void changeEven(int[] arr){
        for (int i = 0; i < arr.length; i+=2) {
            arr[i] = 0;
        }
    }
    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
