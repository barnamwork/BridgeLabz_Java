package level3;

public class MatrixOperations {

    // a. Create random matrix
    public static double[][] createRandomMatrix(int rows, int cols) {
        double[][] mat = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = (int)(Math.random() * 9) + 1;
            }
        }
        return mat;
    }

    // j. Display matrix
    public static void displayMatrix(double[][] mat) {
        for (double[] row : mat) {
            for (double val : row) {
                System.out.printf("%6.2f", val);
            }
            System.out.println();
        }
        System.out.println();
    }

    // b. Matrix addition
    public static double[][] addMatrices(double[][] A, double[][] B) {
        int r = A.length, c = A[0].length;
        double[][] C = new double[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                C[i][j] = A[i][j] + B[i][j];

        return C;
    }

    // c. Matrix subtraction
    public static double[][] subtractMatrices(double[][] A, double[][] B) {
        int r = A.length, c = A[0].length;
        double[][] C = new double[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                C[i][j] = A[i][j] - B[i][j];

        return C;
    }

    // d. Matrix multiplication
    public static double[][] multiplyMatrices(double[][] A, double[][] B) {
        int r = A.length, c = B[0].length, k = B.length;
        double[][] C = new double[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                for (int x = 0; x < k; x++)
                    C[i][j] += A[i][x] * B[x][j];

        return C;
    }

    // e. Transpose
    public static double[][] transpose(double[][] A) {
        double[][] T = new double[A[0].length][A.length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                T[j][i] = A[i][j];
        return T;
    }

    // f. Determinant of 2x2
    public static double determinant2x2(double[][] m) {
        return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
    }

    // g. Determinant of 3x3
    public static double determinant3x3(double[][] m) {
        return m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1])
                - m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0])
                + m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
    }

    // h. Inverse of 2x2
    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        if (det == 0) return null;

        double[][] inv = new double[2][2];
        inv[0][0] =  m[1][1] / det;
        inv[0][1] = -m[0][1] / det;
        inv[1][0] = -m[1][0] / det;
        inv[1][1] =  m[0][0] / det;
        return inv;
    }

    // i. Inverse of 3x3
    public static double[][] inverse3x3(double[][] m) {
        double det = determinant3x3(m);
        if (det == 0) return null;

        double[][] inv = new double[3][3];

        inv[0][0] =  (m[1][1]*m[2][2]-m[1][2]*m[2][1])/det;
        inv[0][1] = -(m[0][1]*m[2][2]-m[0][2]*m[2][1])/det;
        inv[0][2] =  (m[0][1]*m[1][2]-m[0][2]*m[1][1])/det;

        inv[1][0] = -(m[1][0]*m[2][2]-m[1][2]*m[2][0])/det;
        inv[1][1] =  (m[0][0]*m[2][2]-m[0][2]*m[2][0])/det;
        inv[1][2] = -(m[0][0]*m[1][2]-m[0][2]*m[1][0])/det;

        inv[2][0] =  (m[1][0]*m[2][1]-m[1][1]*m[2][0])/det;
        inv[2][1] = -(m[0][0]*m[2][1]-m[0][1]*m[2][0])/det;
        inv[2][2] =  (m[0][0]*m[1][1]-m[0][1]*m[1][0])/det;

        return inv;
    }

    public static void main(String[] args) {

        double[][] A = createRandomMatrix(3, 3);
        double[][] B = createRandomMatrix(3, 3);

        System.out.println("Matrix A:");
        displayMatrix(A);

        System.out.println("Matrix B:");
        displayMatrix(B);

        System.out.println("A + B:");
        displayMatrix(addMatrices(A, B));

        System.out.println("A - B:");
        displayMatrix(subtractMatrices(A, B));

        System.out.println("A × B:");
        displayMatrix(multiplyMatrices(A, B));

        System.out.println("Transpose of A:");
        displayMatrix(transpose(A));

        System.out.println("Determinant of A: " + determinant3x3(A));

        double[][] invA = inverse3x3(A);
        if (invA != null) {
            System.out.println("Inverse of A:");
            displayMatrix(invA);
        } else {
            System.out.println("Inverse does not exist");
        }
    }
}
