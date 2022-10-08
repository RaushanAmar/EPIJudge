package epi.exp;

public class Test2DArray {
    public static void main(String[] args) {
        int[][] a = new int[][] {{1, 2, 3}, {4, 5, 6}};

        System.out.println(a[1][0]);  // Not 2 will be 4 a[row][col]  x = col, y = row

        pMat(a);
    }

    private static void pMat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }

            System.out.println();
        }
    }
}
