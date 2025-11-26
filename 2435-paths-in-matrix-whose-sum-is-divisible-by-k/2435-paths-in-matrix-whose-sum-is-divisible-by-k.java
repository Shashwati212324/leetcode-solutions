class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int MOD = 1_000_000_007;
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k];

        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int val = grid[i][j];

                for (int rem = 0; rem < k; rem++) {

                    if (i > 0) {
                        int prev = dp[i-1][j][rem];
                        if (prev > 0) {
                            int newRem = (rem + val) % k;
                            dp[i][j][newRem] = (dp[i][j][newRem] + prev) % MOD;
                        }
                    }

                    if (j > 0) {
                        int prev = dp[i][j-1][rem];
                        if (prev > 0) {
                            int newRem = (rem + val) % k;
                            dp[i][j][newRem] = (dp[i][j][newRem] + prev) % MOD;
                        }
                    }
                }
            }
        }

        return dp[m-1][n-1][0];
    }
}
