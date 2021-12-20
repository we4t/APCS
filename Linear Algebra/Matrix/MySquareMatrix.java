public class MySquareMatrix extends MyMatrix {
    protected double[] eigenValues;
    protected MyVector eigenVector;

    //constructors
    public MySquareMatrix(String name, int rowOrColNum){
        super(name, rowOrColNum, rowOrColNum);
    }

    public MySquareMatrix(String name, int rowNum, double[][] elements) {
        super(name, rowNum, rowNum, elements);
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[0].length; j++) {
                myElements[i][j] = elements[i][j];
            }
        }
    }
    
    //accessors
    public MySquareMatrix getInverseMatrix(){
        MySquareMatrix inverseMatrix = new MySquareMatrix("inverse Matrix of " + myName, myColNum);
        MySquareMatrix rrefMatrix = new MySquareMatrix("RREF of " + myName, myRowNum, myElements);
        inverseMatrix.setIdentity();
        double pivot;
        for (int i = 0; i < myRowNum; i++) {
            pivot = rrefMatrix.myElements[i][i];
            divideRow(inverseMatrix, i, pivot);
            divideRow(rrefMatrix, i, pivot);
            for(int k = i + 1; k < myRowNum; k++){
                subRow(inverseMatrix, i, k, rrefMatrix.myElements[k][i]);
                subRow(rrefMatrix, i, k, rrefMatrix.myElements[k][i]);
            }
            if(i == myRowNum - 1){
                break;
            }
        }

        for (int i = rrefMatrix.getRowNum() - 1; i >= 1 ; i--) {
            for (int j = i - 1; j >= 0; j--) {
                subRow(inverseMatrix, i, j, rrefMatrix.getArrayElement(j, i));
                subRow(rrefMatrix, i, j, rrefMatrix.getArrayElement(j, i));
            }
        }
        return inverseMatrix;
    }

    public MySquareMatrix matrixDivision(MySquareMatrix divMatrix){
        MySquareMatrix invMatrix = divMatrix.getInverseMatrix();
        MySquareMatrix returnMatrix = (MySquareMatrix)(invMatrix.matrixMultiply(new MySquareMatrix(myName, myRowNum, myElements)));
        return returnMatrix;
    }

    public double getTrace(){
        double sum = 0;
        for (int i = 0; i < myElements.length; i++) {
            sum += myElements[i][i];
        }
        return sum;
    }

    public double getDeterminant(){
        double determinant = 1;
        MyMatrix tmpMatrix = GE();
        for (int i = 0; i < myElements.length; i++) {
            determinant *= tmpMatrix.getArrayElement(i, i);
        }
        return determinant;
    }
    
    
    //modifiers
    public void setIdentity(){
        for (int i = 0; i < myRowNum; i++) {
            for (int j = 0; j < myColNum; j++) {
                if(i == j) myElements[i][j] = 1;
                else myElements[i][j] = 0;
            }
        }
    }
}
