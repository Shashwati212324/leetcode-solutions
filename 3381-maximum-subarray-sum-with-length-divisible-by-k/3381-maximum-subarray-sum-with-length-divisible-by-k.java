class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        
        // Build prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Store minimum prefix sum for each modulo class
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE);
        minPrefix[0] = 0;  // prefix[0] = 0, belongs to mod 0

        long maxSum = Long.MIN_VALUE;

        // Traverse all prefix indices
        for (int i = 1; i <= n; i++) {
            int mod = i % k;

            // If we have seen some prefix with same mod
            if (minPrefix[mod] != Long.MAX_VALUE) {
                long candidate = prefix[i] - minPrefix[mod];
                maxSum = Math.max(maxSum, candidate);
            }

            // Update minimum prefix for this modulo class
            minPrefix[mod] = Math.min(minPrefix[mod], prefix[i]);
        }

        return maxSum;
    }
}
