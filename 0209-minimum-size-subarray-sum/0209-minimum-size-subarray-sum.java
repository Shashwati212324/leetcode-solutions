class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       
        int[] prefix = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int len = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int required = prefix[i] + target;
            int j = lowerBound(prefix, required);

            if (j != -1) {
                len = Math.min(len, j - i);
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }

    private int lowerBound(int[] prefix, int target) {
        int left = 0;
        int right = prefix.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (prefix[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }


        //OPTIMIZED O(n)
        // int len = Integer.MAX_VALUE;
        // int sum = 0;
        // int j = 0;

        // for (int i = 0; i < nums.length; i++) {
        //     sum += nums[i];

        //     while (sum >= target) {
        //         len = Math.min(len, i - j + 1);
        //         sum -= nums[j];
        //         j++;
        //     }
        // }

        // return len == Integer.MAX_VALUE ? 0 : len;

        //BRUTE FORCE
        
    
        //int len = Integer.MAX_VALUE;

        // for (int i = 0; i < nums.length; i++) {
        //     int j = i + 1;
        //     int sum = nums[i];
        //     int count = 1;

        //     if (sum >= target) return 1;

        //     while (sum < target && j < nums.length) {
        //         sum += nums[j];
        //         j++;
        //         count++;
        //     }

        //     if (sum >= target) {
        //         len = Math.min(len, count);
        //     }
        // }

        // return len == Integer.MAX_VALUE ? 0 : len;
    
     
    
}