class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;

        // 1. strictly increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0) return false; // no increasing part

        // 2. strictly decreasing
        int p = i;
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }
        if (i == p) return false; // no decreasing part

        // 3. strictly increasing
        int q = i;
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == q) return false; // no last increasing part

        // must reach the end
        return i == n - 1;
    }
}
