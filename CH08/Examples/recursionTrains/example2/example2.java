package Examples.recursionTrains.example2;

public class example2 {
    public static void main(String[] args) {
        revDigs(741);
    }

    public static void revDigs(int num){
        System.out.println(num % 10);
        if(num / 10 != 0){
            revDigs(num/10);
        }
    }
}
