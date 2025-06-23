class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[2];
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            // Duplicate detected
            if (nums[i] == nums[i - 1]) {
                ans[0] = nums[i];
            }

            // Missing number is the gap between two numbers
            if (nums[i] > nums[i - 1] + 1) {
                ans[1] = nums[i - 1] + 1;
            }
        }

        // Check if missing number is at the beginning
        if (nums[0] != 1) {
            ans[1] = 1;
        }
        // Check if missing number is at the end
        else if (nums[n - 1] != n) {
            ans[1] = n;
        }
        return ans;
        
    }    
}