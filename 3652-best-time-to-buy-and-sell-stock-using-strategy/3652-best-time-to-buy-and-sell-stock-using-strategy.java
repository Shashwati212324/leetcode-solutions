class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long originalProfit = 0;

        for (int i = 0; i < n; i++) {
            originalProfit += (long) strategy[i] * prices[i];
        }

        long[] gainHold = new long[n];
        long[] gainSell = new long[n];

        for (int i = 0; i < n; i++) {
            gainHold[i] = -(long) strategy[i] * prices[i];
            gainSell[i] = (long) (1 - strategy[i]) * prices[i];
        }

        long[] prefixHold = new long[n + 1];
        long[] prefixSell = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefixHold[i + 1] = prefixHold[i] + gainHold[i];
            prefixSell[i + 1] = prefixSell[i] + gainSell[i];
        }

        long maxExtra = 0;
        int half = k / 2;

        for (int l = 0; l + k <= n; l++) {
            long holdGain =
                prefixHold[l + half] - prefixHold[l];

            long sellGain =
                prefixSell[l + k] - prefixSell[l + half];

            maxExtra = Math.max(maxExtra, holdGain + sellGain);
        }

        return originalProfit + maxExtra;
    }
}
