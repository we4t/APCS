import java.util.*;

class Aug28 {
    public static void main(String[] args) {
        long millis = System.currentTimeMillis();
        Random rnd = new Random(millis);

        // initializing variables
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the total execute time");
        long executeTime = sc.nextLong(); // user input
        long[] howManyIntegers = new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        // executing
        for (int i = 0; i < executeTime; i++) {
            int tmp = (int) (rnd.nextDouble() * 100);
            howManyIntegers[tmp / 10]++;
        }

        // printing the indexes of experiment
        for (int i = 0; i < howManyIntegers.length; i++) {
            System.out.printf("%d ~ %d : %d", i * 10, (i + 1) * 10 - 1, howManyIntegers[i]);
            System.out.println(", " + Math.round((double) howManyIntegers[i] / executeTime * 1000) / 10.0 + "%");
        }
        System.out.println("average : " + getAverage(howManyIntegers));
        System.out.println("Standard Deviation : " + getStandardDeviation(howManyIntegers));

    }

    public static double getAverage(long[] list) {
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        return (double) sum / list.length;
    }

    public static double getStandardDeviation(long[] list) {
        double average = getAverage(list);
        double deviationSum = 0;
        for (int i = 0; i < list.length; i++) {
            deviationSum += (list[i] - average) * (list[i] - average);
        }
        return Math.sqrt(deviationSum / (list.length));
    }
}