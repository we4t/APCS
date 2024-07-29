import java.util.*;

class GaussElimination {
    public static void main(String[] Args) {
        Scanner sc = new Scanner(System.in);
        int sizeOfArray = sc.nextInt();
        float[][] userInputMatrix = new float[sizeOfArray][sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            for (int j = 0; j < sizeOfArray; j++) {
                userInputMatrix[i][j] = sc.nextFloat();
            }
        }

        userInputMatrix = gaussElimination(userInputMatrix);
        for (int i = 0; i < userInputMatrix.length; i++) {
            for (int j = 0; j < userInputMatrix.length; j++) {
                System.out.print(userInputMatrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();

    }

    public static float[][] gaussElimination(float[][] matrix) {
        int sizeOfArray = matrix.length;
        float pivot, pivot2;
        for (int i = 0; i < sizeOfArray; i++) {
            pivot = matrix[i][i];
            for (int j = i; j < sizeOfArray; j++) {
                matrix[i][j] /= pivot;
            }
            for (int j = i+1; j < matrix.length; j++) {
                pivot2 = matrix[j][i];
                for (int j2 = 0; j2 < matrix.length; j2++) {
                    matrix[j][j2] -= matrix[i][j2] * pivot2;
                }    
            }
        }
        return matrix;
    }
}