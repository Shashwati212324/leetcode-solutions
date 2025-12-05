class Solution {
    public int countPartitions(int[] nums) {
        int total = 0;
        for (int x : nums) total += x;
        
        // If total is odd, no partition gives even difference
        if (total % 2 != 0) return 0;
        
        // If total is even, all partitions are valid
        return nums.length - 1;
    }
}
