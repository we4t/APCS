public class Matrix {
    private double[][] matrix;

    //constructor
    public Matrix(double a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                matrix[i][j] = a[i][j];
            }
        }
    }

    public Matrix(int row, int col){
        matrix = new double[row][col];
    }

    public Matrix(){
        this(new double[][] {{1,0},{0,1}});
    }

    //accessor
    public double getMatrixIndex(Matrix a, int row, int column){
        return a.matrix[row][column];
    }

    public int getMatrixRowNum(Matrix a){
        return a.matrix.length; 
    }

    public int getMatrixColNum(Matrix a){
        return a.matrix[0].length;
    }

    //modifier

    //matrix operator
    
    public static Matrix matrixAddition(Matrix a, Matrix b){
        Matrix returnMatrix = new Matrix();
        for (int i = 0; i < a.getMatrixRowNum(a); i++) {
            for (int j = 0; j < a.getMatrixColNum(a); j++) {
                return null;
            }
            
        }
    }

    public static Matrix matrixSubtration(Matrix a, Matrix b){

    }

    public static Matrix matrixDotProduct(Matrix a, Matrix b){
        
    }

    public static Matrix matrixDivision(Matrix a, Matrix b){

    }

    public static Matrix getTransposeMatrix(Matrix a){

    }
}
