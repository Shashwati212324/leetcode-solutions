class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][] dp = new long[k + 1][n];

        for (int t = 1; t <= k; t++) {
            long bestBuy = -prices[0];
            long bestSell = prices[0];

            for (int i = 1; i < n; i++) {
                dp[t][i] = Math.max(
                    dp[t][i - 1],
                    Math.max(
                        prices[i] + bestBuy,
                        bestSell - prices[i]
                    )
                );

                // IMPORTANT FIX: use dp[t-1][i-1]
                bestBuy = Math.max(bestBuy, dp[t - 1][i - 1] - prices[i]);
                bestSell = Math.max(bestSell, dp[t - 1][i - 1] + prices[i]);
            }
        }

        return dp[k][n - 1];
    }
}
