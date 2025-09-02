class Solution {
   public int numSquares(int n) {
        // Precompute all perfect squares <= n
        ArrayList<Integer> squares = new ArrayList<>();
         int i = 1;
        while (i * i <= n) {
            squares.add(i * i);
            i++;
        }

        // DP array
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // base case

        // Build up the solution
        for (int num = 1; num <= n; num++) {
            for (int square : squares) {
                if (square > num) break;
                dp[num] = Math.min(dp[num], dp[num - square] + 1);
            }
        }

        return dp[n];
    }
}