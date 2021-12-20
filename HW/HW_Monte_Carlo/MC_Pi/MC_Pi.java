import java.util.Random;

public class MC_Pi {
    public static void main(String[] args) {
        
        //attributes
        double x, y, mcPI = 0, error = 0; // point P
        int executeTime = 10000005; // total loop
        final double realPI = Math.PI; // PI
        int inner = 0, exp = 10;
        Random rnd = new Random(System.currentTimeMillis());

        // Monte Carlo Simulation calculating PI
        for (int i = 1; i <= executeTime; i++) {
            x = rnd.nextDouble();
            y = rnd.nextDouble();
            if(x*x + y*y < 1) inner++;
            mcPI = (double)inner/i*4;
            error = Math.abs(mcPI-realPI)/realPI*100;
            if(i % exp == 0){
                System.out.printf("execute time : %d, pi : %f , error : %f\n", i, mcPI, error);
                exp*=10;
            }
        }
        System.out.println("final output : ");
        System.out.printf("execute time : %d, pi : %f , error : %f", executeTime, mcPI, error);    
    }
}
