import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int specialTriplets(int[] nums) {
        int n = nums.length;
        // We need counts of numbers > j (suffix) and track counts before j (prefix).
        // Since nums[i] ≤ 1e5, 2 * nums[j] ≤ 2e5 — we can use a map or array of adequate size.
        // Use a HashMap for generality:
        Map<Integer, Integer> suffix = new HashMap<>();
        for (int x : nums) {
            suffix.put(x, suffix.getOrDefault(x, 0) + 1);
        }

        Map<Integer, Integer> prefix = new HashMap<>();
        long ans = 0;

        for (int j = 0; j < n; j++) {
            int m = nums[j];
            // Remove current from suffix (now j acts as the middle element)
            suffix.put(m, suffix.get(m) - 1);
            if (suffix.get(m) == 0) {
                suffix.remove(m);
            }

            long cntLeft  = prefix.getOrDefault(m * 2, 0);
            long cntRight = suffix.getOrDefault(m * 2, 0);
            ans = (ans + cntLeft * cntRight) % MOD;

            // Add current to prefix
            prefix.put(m, prefix.getOrDefault(m, 0) + 1);
        }

        return (int) ans;
    }
}
