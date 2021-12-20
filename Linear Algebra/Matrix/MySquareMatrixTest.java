class MySquareMatrixTest {
    public static void main(String[] args) {
        MySquareMatrix matA = new MySquareMatrix("A", 5);
        MySquareMatrix matB = new MySquareMatrix("B", 5);
        matA.setRand(0, 10);
        matB = matA.getInverseMatrix();
        System.out.println(matA.matrixMultiply(matB));
    }
}
