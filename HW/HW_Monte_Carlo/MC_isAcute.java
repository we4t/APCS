import java.util.Random;

import javax.lang.model.util.ElementScanner14;

public class MC_isAcute {
    public static void main(String[] args) {
        final int loop = 1000000;
        Random rnd = new Random(System.currentTimeMillis());
        double ax, ay, bx, by, ab, theta1, theta2;
        int n = 0, exp = 10;
        for(int i = 1; i <= loop; i++){
            theta1 = 2*Math.PI*rnd.nextDouble();
            theta2 = 2*Math.PI*rnd.nextDouble();
            ax = Math.cos(theta1);
            bx = Math.cos(theta2);
            ay = Math.sin(theta1);
            by = Math.sin(theta2);
            ab = Math.sqrt((ax-bx)*(ax-bx) + (ay-by)*(ay-by));
            if(ab > Math.sqrt(3)) n++;
            if(i%exp == 0) {
                System.out.println(i + " " + (double)n/i);
                exp *= 10;
            }
        }
        System.out.println((double)n/loop);
    }
}
