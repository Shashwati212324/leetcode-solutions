class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int n = nums.length;

        int m1 = Integer.MIN_VALUE, m2 = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Find 2 largest + 1 smallest
        for (int x : nums) {
            if (x > m1) {
                m2 = m1;
                m1 = x;
            } else if (x > m2) {
                m2 = x;
            }
            min = Math.min(min, x);
        }

        return m1 + m2 - min;
    }
}