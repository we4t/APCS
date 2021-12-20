public class MyMatrixTest {
    public static void main(String[] args) {
        MyMatrix matA, matX, matB, matXH;
        /*double[] errors = new double[2];
        double absSum = 0, devSum = 0;
        int executeTime = 100;
        for (int i = 0; i < executeTime; i++) {
            matA = new MySquareMatrix("A", 100);
            matX = new MyMatrix("X", 100, 1);
            matA.setRand(-10, 10);
            matX.setRand(-10, 10);
            matB = matA.matrixMultiply(matX);
            matXH = new MyMatrix(matB);
            matA.GEBS(matXH);
            errors = matX.getError(matXH);
            absSum += errors[0];
            devSum += errors[1];
            if (i % (executeTime / 100) == 0)
                System.out.println(i);
        }

        System.out.println(absSum / executeTime + " " + devSum / executeTime);
        */
        matA = new MyMatrix("A", 9, 7);
        matA.setRand(-10, 10);
        matX = new MyMatrix(matA);
        System.out.println(matA);
        matA.GE();
        System.out.println(matA);
        matX.GEBS();
        System.out.println(matX);
    }
}