class Solution {
    static final long MOD = 1_000_000_007;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;

        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];

        dp[0] = 1;
        pref[0] = 1;

        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();

        int left = 0;

        for (int i = 0; i < n; i++) {

            // Insert nums[i] into maxDeque
            while (!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[i])
                maxD.pollLast();
            maxD.addLast(i);

            // Insert nums[i] into minDeque
            while (!minD.isEmpty() && nums[minD.peekLast()] >= nums[i])
                minD.pollLast();
            minD.addLast(i);

            // Shrink left boundary until valid
            while (!maxD.isEmpty() && !minD.isEmpty()
                    && (nums[maxD.peekFirst()] - nums[minD.peekFirst()] > k)) {

                if (maxD.peekFirst() == left) maxD.pollFirst();
                if (minD.peekFirst() == left) minD.pollFirst();
                left++;
            }

            // dp[i+1] = sum of dp[left .. i]
            dp[i + 1] = (pref[i] - (left == 0 ? 0 : pref[left - 1]) + MOD) % MOD;

            // update prefix
            pref[i + 1] = (pref[i] + dp[i + 1]) % MOD;
        }

        return (int) dp[n];
    }
}
