package Examples.recursionTrains.example1;

public class example1 {
    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        else{
            return n * factorial (n-1);
        }
    }
}
