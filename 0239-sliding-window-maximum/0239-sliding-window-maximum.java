class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //TLE - Brute Force
        // int[] result = new int[nums.length-k+1];
        // int index =0;
        // for(int j = k-1;j<nums.length;j++){
        //     int max= Integer.MIN_VALUE;
        //     for(int i =j-k+1; i<=j ; i++){
        //         max = Math.max(max, nums[i]);

        //     }
        //     result[index++]=max;
        // }
        // return result;

         Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {

            // Remove elements outside the window
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            // Window is ready
            if (i >= k - 1) {
                result[idx++] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}