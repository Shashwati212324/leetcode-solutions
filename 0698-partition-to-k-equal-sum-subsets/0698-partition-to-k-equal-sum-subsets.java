class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % k != 0) return false;

        int target = sum / k;

        Arrays.sort(nums);
        int n = nums.length;

        if (nums[n - 1] > target) return false;

        boolean[] visited = new boolean[n];

        return backtrack(nums, visited, k, 0, 0, target);
    }

    private boolean backtrack(int[] nums, boolean[] visited,
                              int k, int startIndex, int currSum, int target) {

        // Base case: only 1 bucket left
        if (k == 1) return true;

        // If current bucket is full, move to next bucket
        if (currSum == target) {
            return backtrack(nums, visited, k - 1, 0, 0, target);
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (visited[i] || currSum + nums[i] > target) continue;

            visited[i] = true;

            if (backtrack(nums, visited, k, i + 1, currSum + nums[i], target)) {
                return true;
            }

            visited[i] = false;

            // Optimization: if placing nums[i] in empty bucket doesn't work,
            // no point in trying same number again.
            if (currSum == 0) break;
        }
        return false;
    }
}
