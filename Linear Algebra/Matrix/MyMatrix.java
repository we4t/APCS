import java.util.*;

public class MyMatrix {
    protected String myName;
    protected int myRowNum, myColNum;
    protected double[][] myElements;
    protected static Random rnd = new Random(System.currentTimeMillis());

    // constructors
    public MyMatrix() {
        myName = "default Matrix";
        myRowNum = 0;
        myColNum = 0;
        myElements = new double[myRowNum][myColNum];
    }

    public MyMatrix(String name, int rowNum, int colNum) {
        myName = name;
        myRowNum = rowNum;
        myColNum = colNum;
        myElements = new double[rowNum][colNum];
    }

    public MyMatrix(String name, int rowNum, int colNum, double[][] elements) {
        super();
        myName = name;
        myRowNum = rowNum;
        myColNum = colNum;
        myElements = new double[rowNum][colNum];
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[0].length; j++) {
                setElement(elements[i][j], i, j);
            }
        }
    }

    public MyMatrix(MyMatrix tmpMatrix) {
        super();
        myName = "copy of " + tmpMatrix.getMatrixName();
        myRowNum = tmpMatrix.getRowNum();
        myColNum = tmpMatrix.getColNum();
        myElements = new double[myRowNum][myColNum];
        for (int i = 0; i < myElements.length; i++) {
            for (int j = 0; j < myElements[0].length; j++) {
                setElement(tmpMatrix.getArrayElement(i, j), i, j);
            }
        }
    }

    // accessors
    public double getArrayElement(int tmpRow, int tmpCol) {
        return myElements[tmpRow][tmpCol];
    }

    public double getMatrixElement(int tmpRow, int tmpCol) {
        return myElements[tmpRow - 1][tmpCol - 1];
    }

    public int getRowNum() {
        return myRowNum;
    }

    public int getColNum() {
        return myColNum;
    }

    public String getMatrixName() {
        return myName;
    }

    public MyMatrix matrixAdd(MyMatrix addingMatrix) {
        return matrixAdd(myName + " + " + addingMatrix.getMatrixName(), addingMatrix);
    }

    public MyMatrix matrixAdd(String name, MyMatrix addingMatrix) {
        if (!isSameSize(addingMatrix)) {
            throw new IllegalArgumentException("the size of matrices are not identical.");
        }
        MyMatrix resultMatrix = new MyMatrix(name, addingMatrix.getRowNum(), addingMatrix.getColNum());
        for (int i = 0; i < myElements.length; i++) {
            for (int j = 0; j < myElements[0].length; j++) {
                resultMatrix.setElement(myElements[i][j] + addingMatrix.getArrayElement(i, j), i, j);
            }
        }
        return resultMatrix;
    }

    public MyMatrix matrixSub(MyMatrix subMatrix) {
        return matrixSub(myName + " - " + subMatrix.getMatrixName(), subMatrix);
    }

    public MyMatrix matrixSub(String name, MyMatrix subMatrix) {
        if (!isSameSize(subMatrix)) {
            throw new IllegalArgumentException("the size of matrices are not identical.");
        }
        MyMatrix resultMatrix = new MyMatrix(name, subMatrix.getRowNum(), subMatrix.getColNum());
        for (int i = 0; i < myElements.length; i++) {
            for (int j = 0; j < myElements[0].length; j++) {
                resultMatrix.setElement(myElements[i][j] - subMatrix.getArrayElement(i, j), i, j);
            }
        }
        return resultMatrix;
    }

    public MyMatrix matrixMultiply(MyMatrix mulMatrix) {
        return matrixMultiply(myName + " dot " + mulMatrix.getMatrixName(), mulMatrix);
    }

    public MyMatrix matrixMultiply(String name, MyMatrix mulMatrix) {
        if (myColNum != mulMatrix.getRowNum()) {
            throw new IllegalArgumentException("the number of column of matrix " + myName
                    + "is not same as the number of row of matrix " + mulMatrix.getMatrixName());
        }
        MyMatrix resultMatrix = new MyMatrix(name, myRowNum, mulMatrix.getColNum());
        double sum;
        for (int i = 0; i < myElements.length; i++) {
            for (int j = 0; j < mulMatrix.getColNum(); j++) {
                sum = 0;
                for (int k = 0; k < myColNum; k++) {
                    sum = sum + myElements[i][k] * mulMatrix.getArrayElement(k, j);
                }
                resultMatrix.setElement(sum, i, j);
            }
        }
        return resultMatrix;
    }

    public MyMatrix matrixScalar(double c) {
        MyMatrix scalarMatrix = new MyMatrix(c + " dot " + myName, myRowNum, myColNum);

        for (int i = 0; i < myRowNum; i++) {
            for (int j = 0; j < myColNum; j++) {
                scalarMatrix.setElement(myElements[i][j] * c, i, j);
            }
        }

        return scalarMatrix;
    }

    public void GE() {
        double pivot;
        for (int i = 0; i < Math.min(myRowNum, myColNum); i++) {
            pivot = myElements[i][i];
            for (int j = 0; j < myColNum; j++) {
                myElements[i][j] /= pivot;    
            }
            for (int j = i + 1; j < myRowNum; j++) {
                pivot = myElements[j][i];
                for (int k = 0; k < myColNum; k++) {
                    myElements[j][k] -= myElements[i][k] * pivot; 
                }
            }
        }
    }

    public void GEBS() {
        double pivot;
        for (int i = 0; i < Math.min(myRowNum, myColNum); i++) {
            pivot = myElements[i][i];
            for (int j = 0; j < myColNum; j++) {
                myElements[i][j] /= pivot;    
            }
            for (int j = i + 1; j < myRowNum; j++) {
                pivot = myElements[j][i];
                for (int k = 0; k < myColNum; k++) {
                    myElements[j][k] -= myElements[i][k] * pivot; 
                }
            }
        }
        for (int i = Math.min(myRowNum, myColNum) - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                pivot = myElements[j][i];
                for (int k = 0; k < myColNum; k++) {
                    myElements[j][k] -= pivot * myElements[i][k];
                }
            }
        }
    }

    public MyMatrix GE(MyMatrix tmpMatrix) {
        MyMatrix refMatrix = new MyMatrix("REF of " + myName, myRowNum, myColNum, myElements);
        double pivot;
        for (int i = 0; i < Math.max(refMatrix.getRowNum(), refMatrix.getColNum()); i++) {
            pivot = refMatrix.myElements[i][i];
            divideRow(tmpMatrix, i, pivot);
            divideRow(refMatrix, i, pivot);
            for (int k = i + 1; k < myRowNum; k++) {
                subRow(tmpMatrix, i, k, refMatrix.myElements[k][i]);
                subRow(refMatrix, i, k, refMatrix.myElements[k][i]);
            }
            if (i == myRowNum - 1) {
                break;
            }
        }
        return tmpMatrix;
    }

    public MyMatrix GEBS(MyMatrix tmpMatrix) {
        MyMatrix rrefMatrix = new MyMatrix("RREF of " + myName, myRowNum, myColNum, myElements);
        double pivot;
        for (int i = 0; i < Math.max(rrefMatrix.getRowNum(), rrefMatrix.getColNum()); i++) {
            pivot = rrefMatrix.myElements[i][i];
            divideRow(tmpMatrix, i, pivot);
            divideRow(rrefMatrix, i, pivot);
            for (int k = i + 1; k < myRowNum; k++) {
                subRow(tmpMatrix, i, k, rrefMatrix.myElements[k][i]);
                subRow(rrefMatrix, i, k, rrefMatrix.myElements[k][i]);
            }
            if (i == myRowNum - 1) {
                break;
            }
        }
        for (int i = rrefMatrix.getRowNum() - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                subRow(tmpMatrix, i, j, rrefMatrix.getArrayElement(j, i));
                subRow(rrefMatrix, i, j, rrefMatrix.getArrayElement(j, i));
            }
        }
        return tmpMatrix;
    }

    public MyMatrix getTransposeMatrix() {
        MyMatrix transposeMatrix = new MyMatrix("Transpose of " + myName, myColNum, myRowNum);
        for (int i = 0; i < myElements.length; i++) {
            for (int j = 0; j < myElements[0].length; j++) {
                transposeMatrix.setElement(myElements[i][j], j, i);
            }
        }
        return transposeMatrix;
    }

    public MyMatrix getAbsMatrix(MyMatrix absMatrix) {
        if (!isSameSize(absMatrix)) {
            throw new IllegalArgumentException("the size of matrices are not identical.");
        }
        double tmpAbs;
        MyMatrix resultMatrix = new MyMatrix(myName + "_abs_" + absMatrix.getMatrixName(), myRowNum, myColNum);
        for (int i = 0; i < myRowNum; i++) {
            for (int j = 0; j < myColNum; j++) {
                tmpAbs = Math.abs(myElements[i][j] - absMatrix.getArrayElement(i, j));
                resultMatrix.setElement(tmpAbs, i, j);
            }
        }
        return resultMatrix;
    }

    public double[] getError(MyMatrix errMatrix) {
        double[] errors = new double[2];
        double sum = 0, tmp, deviationSum = 0;
        if (!isSameSize(errMatrix)) {
            throw new IllegalArgumentException("the size of matrices are not identical.");
        }
        double[][] error = new double[errMatrix.getRowNum()][errMatrix.getColNum()];
        for (int i = 0; i < myRowNum; i++) {
            for (int j = 0; j < myColNum; j++) {
                tmp = myElements[i][j] - errMatrix.getArrayElement(i, j);
                error[i][j] = (Math.abs(tmp));
                sum += error[i][j];
            }
        }
        double meanAbs = sum / (myRowNum * myColNum);
        for (int i = 0; i < myRowNum; i++) {
            for (int j = 0; j < myColNum; j++) {
                deviationSum += (meanAbs - error[i][j]) * (meanAbs - error[i][j]);
            }
        }
        errors[0] = meanAbs;
        errors[1] = Math.sqrt(deviationSum / (myRowNum * myColNum));
        return errors;
    }

    public boolean isEqual(MyMatrix tmpMatrix) {
        boolean returnValue = true;

        if (isSameSize(tmpMatrix) == false) {
            throw new IllegalArgumentException("the size of matrices are not identical.");
        }
        for (int i = 0; i < myRowNum; i++) {
            for (int j = 0; j < myColNum; j++) {
                if (!isDoublesEqual(myElements[i][j], tmpMatrix.getArrayElement(i, j))) {
                    returnValue = false;
                }
            }
        }
        return returnValue;
    }

    protected boolean isSameSize(MyMatrix tmpMatrix) {
        if (myRowNum != tmpMatrix.getRowNum() || myColNum != tmpMatrix.getColNum()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isDoublesEqual(double a, double b) {
        if (Math.abs(a - b) < Math.pow(10, -15) * Math.max(Math.abs(a), Math.abs(b))) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean isSquare() {
        if (myColNum == myRowNum) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean isSquare(MyMatrix tmpMatrix) {
        if (tmpMatrix.getRowNum() == tmpMatrix.getColNum()) {
            return true;
        } else {
            return false;
        }
    }

    protected int countNumOfValue(double cntValue) {
        int cnt = 0;
        for (int i = 0; i < myElements.length; i++) {
            for (int j = 0; j < myElements[0].length; j++) {
                if (myElements[i][j] == cntValue)
                    cnt++;
            }
        }
        return cnt;
    }

    protected boolean isArrayIndexOutOfBound(int row, int col) {
        if (row >= myRowNum || col >= myColNum) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean isMatrixIndexOutOfBound(int row, int col) {
        return isArrayIndexOutOfBound(row - 1, col - 1);
    }

    protected int findFirstNonzero(int startRow, int currentCol) {
        int col = currentCol;
        for (int i = startRow; i < myRowNum; i++) {
            if (myElements[i][col] != 0) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        String msg = new String("");
        msg += myName + "\n";
        msg += String.format("%dX%d\n", myRowNum, myColNum);
        for (int i = 0; i < myElements.length; i++) {
            for (int j = 0; j < myElements[0].length; j++) {
                msg += getArrayElement(i, j) + "\t";
            }
            msg += "\n";
        }
        return msg;
    }

    // mutators
    public void setElement(double value, int tmpRow, int tmpCol) {
        myElements[tmpRow][tmpCol] = value;
    }

    public void setZero() {
        for (int i = 0; i < myElements.length; i++) {
            for (int j = 0; j < myElements[0].length; j++) {
                myElements[i][j] = 0;
            }
        }
    }

    public void setRand() {
        for (int i = 0; i < myElements.length; i++) {
            for (int j = 0; j < myElements[0].length; j++) {
                myElements[i][j] = rnd.nextDouble();
            }
        }
    }

    public void setRand(int min, int max) {
        for (int i = 0; i < myElements.length; i++) {
            for (int j = 0; j < myElements[0].length; j++) {
                myElements[i][j] = (max - min) * rnd.nextDouble() + min;
            }
        }
    }

    public void setRandInt(int min, int max) {
        for (int i = 0; i < myElements.length; i++) {
            for (int j = 0; j < myElements[0].length; j++) {
                myElements[i][j] = (int) ((max - min) * rnd.nextDouble() + min);
            }
        }
    }

    public void uniteAllValue(double value) {
        for (int i = 0; i < myElements.length; i++) {
            for (int j = 0; j < myElements[0].length; j++) {
                myElements[i][j] = value;
            }
        }
    }

    public void swapRow(MyMatrix tmpMatrix, int row1, int row2) {
        double[] tmpRow;
        tmpRow = myElements[row1];
        myElements[row1] = myElements[row2];
        myElements[row2] = tmpRow;
    }

    public void setIdentity() {
        if (!isSquare()) {
            throw new IllegalArgumentException("the Matrix " + myName + " is not a Square Matrix");
        }
        for (int i = 0; i < myRowNum; i++) {
            for (int j = 0; j < myColNum; j++) {
                if (i == j)
                    myElements[i][j] = 1;
                else
                    myElements[i][j] = 0;
            }

        }
    }

    protected void divideRow(MyMatrix tmpMatrix, int row, double scalar) {
        if (scalar != 0) {
            for (int i = 0; i < tmpMatrix.getColNum(); i++) {
                tmpMatrix.myElements[row][i] /= scalar;
            }
        }
    }

    protected void subRow(MyMatrix tmpMatrix, int pivotRow, int subjectRow, double scalar) { // row2 - row1*scalar{
        for (int i = 0; i < tmpMatrix.getColNum(); i++) {
            tmpMatrix.myElements[subjectRow][i] -= tmpMatrix.myElements[pivotRow][i] * scalar;
        }
    }
}