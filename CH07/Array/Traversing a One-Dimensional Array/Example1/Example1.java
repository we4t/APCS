public class Example1 {
    public static void main(String[] args) {
        int[] a = new int[100];
        int cntEven;
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        cntEven = countEven(a);
        System.out.println(cntEven);
    }

    public static int countEven(int[] arr){
        int count = 0;
        for (int num : arr) {
            if(num % 2 == 0)
                count++;
        }
        return count;
    }
}
