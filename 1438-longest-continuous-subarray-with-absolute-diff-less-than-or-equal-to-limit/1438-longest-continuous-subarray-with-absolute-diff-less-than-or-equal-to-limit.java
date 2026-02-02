class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDQ = new ArrayDeque<>();
        Deque<Integer> minDQ = new ArrayDeque<>();

        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            // Maintain max deque (decreasing)
            while (!maxDQ.isEmpty() && nums[maxDQ.peekLast()] < nums[right]) {
                maxDQ.pollLast();
            }
            maxDQ.offerLast(right);

            // Maintain min deque (increasing)
            while (!minDQ.isEmpty() && nums[minDQ.peekLast()] > nums[right]) {
                minDQ.pollLast();
            }
            minDQ.offerLast(right);

            // Shrink window if invalid
            while (nums[maxDQ.peekFirst()] - nums[minDQ.peekFirst()] > limit) {
                if (maxDQ.peekFirst() == left) maxDQ.pollFirst();
                if (minDQ.peekFirst() == left) minDQ.pollFirst();
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
