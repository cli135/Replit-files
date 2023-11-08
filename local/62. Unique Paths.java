class Solution {
    // sheesh that was incredibly fast, 2ms
    // so yeah dp is better instead of doing factorials
    // cool
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // this is just pascals triangle
        // filling in top and left rows with ones
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // ok now applying pascal's identity/rule
        
        for (int i = 1 ; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // pascal's identity
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
        
    }
    // combinatorics requires large numbers like BigInteger
    // since it goes so high
    // dp just goes as high as it needs to without any higher
    public int uniquePaths1(int m, int n) {
        if (m == 1 || n == 1) {
            return 1; // horiz or vert
        }
        // combinatorics
        int a = m - 1;
        int b = n - 1;
        return nCr(a + b, a);
    }
    private int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    private int nPr(int n, int r) {
        return factorial(n) / factorial(n - r);
    }
    private int nCr(int n, int r) {
        if (r > n / 2) {
            return nCr(n, n - r); // save time
            // symmetric
        }
        return nPr(n, r) / factorial(r);
    }
}
