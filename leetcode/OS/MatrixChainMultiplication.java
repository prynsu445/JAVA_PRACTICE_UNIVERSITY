public class MatrixChainMultiplication {

    // Function to find minimum number of multiplications
    public static int matrixChainOrder(int[] p) {
        int n = p.length;

        // m[i][j] = minimum cost to multiply matrices Ai...Aj
        int[][] m = new int[n][n];

        // cost is 0 when multiplying one matrix
        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        // L = chain length
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] 
                             + p[i - 1] * p[k] * p[j];

                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                    }
                }
            }
        }

        return m[1][n - 1];
    }

    public static void main(String[] args) {
        int[] p = {10, 20, 30, 40, 30};

        int result = matrixChainOrder(p);
        System.out.println("Minimum number of multiplications: " + result);
    }
}