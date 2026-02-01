class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros =0;
        int left =0;
        int len =0;
        for(int i =0;i<nums.length;i++){
            if(nums[i] == 0){
                zeros++;
            }

            while(zeros>k){
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            len = Math.max(len, i-left+1);

        }
        return len;

        
    }
}