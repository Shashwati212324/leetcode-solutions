class Solution {
    public long getDescentPeriods(int[] prices) {
        long count = 1;     // at least one single-element subarray
        long curr = 1;      // current smooth descent length

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                curr++;
            } else {
                curr = 1;
            }
            count += curr;
        }

        return count;
    }
}
