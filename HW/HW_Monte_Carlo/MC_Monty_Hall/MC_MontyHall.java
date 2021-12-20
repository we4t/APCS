import java.util.Random;

public class MC_MontyHall {
    public static void main(String[] args) {
        
        //variables
        Random rnd = new Random(System.currentTimeMillis());
        int present = 0, choice = 0;
        int executeTime = 1000000, exp = 10;
        int secondChangeTime = 0, secondStillTime = 0; 
        
        //experimenting for changing choice
        for (int i = 1; i <= executeTime; i++) {
            present = rnd.nextInt(3);
            choice = rnd.nextInt(3);
            // having an experiment with same circumstance
            // chainging choice
            if(choice != present){
                secondChangeTime++;
            }
            // unchainging choice
            if(choice == present){
                secondStillTime++;
            }
            if(i%exp == 0){
                System.out.println(" i : " + i);
                System.out.println((double)secondChangeTime/i + " " + (double)secondStillTime/i);
                System.out.println();
                exp*=10;
            }

        }
        System.out.println((double)secondChangeTime/executeTime + " " + (double)secondStillTime/executeTime);

    }
}
