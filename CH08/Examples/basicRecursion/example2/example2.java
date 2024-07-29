package Examples.basicRecursion.example2;

public class example2 {
    public static void main(String[] args) {
        //catastrophe(1); do not execute..
    }

    public void catastrophe(int n){
        System.out.println(n);
        catastrophe(n);
    }
}
