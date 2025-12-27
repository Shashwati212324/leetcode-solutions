class Solution {
    public int pivotIndex(int[] nums) {

        int n = nums.length;

        // ✅ Edge case: single element
        if (n == 1) return 0;

        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        // ✅ Check pivot at index 0
        if (prefix[n - 1] - prefix[0] == 0) {
            return 0;
        }

        // ✅ Check middle indices
        for (int i = 1; i < n - 1; i++) {
            if (prefix[i - 1] == prefix[n - 1] - prefix[i]) {
                return i;
            }
        }

        // ✅ Check pivot at last index
        if (prefix[n - 2] == 0) {
            return n - 1;
        }

        return -1;
    }
}
