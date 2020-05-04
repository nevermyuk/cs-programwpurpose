/*
1.4.18 Write a code fragment to multiply two rectangular matrices that are not necessarily square.
Note: For the dot product to be well defined,
the number of columns in the first matrix must be equal to the number of rows in the second matrix.
Print an error message if the dimensions do not satisfy this condition.
 */

public class MultiplyTwoMatrices {
    public static void main(String[] args) {
        boolean inOrder = false;
        double[][] a = new double[][]{
                {3, 2, 1, 5},
                {9, 1, 3, 0},
                {2, 4, 7, 0}};
        double[][] b = new double[][]{
                {2, 9, 0},
                {1, 3, 5},
                {2, 4, 7},
                {8, 1, 5}};
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            if (a[i].length == b.length)
            {
                inOrder = true;
            } else
            {
                inOrder = false;
                System.out.print("Error: Column of first matrix " + a[i].length + " is not equal to " + b.length + " rows in second matrix.");
                break;
            }
        }
        if (inOrder) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b[i].length; j++) {
                    for (int k = 0; k < a[i].length; k++) {
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            for (int i = 0; i < c.length; i++) {
                System.out.print("[");
                for (int j = 0; j < c[i].length; j++) {
                    System.out.print(c[i][j]);
                    if (j < c[i].length - 1) System.out.print(", ");
                }
                System.out.print("] ");
                System.out.print("\n");
            }
        }
    }
}
