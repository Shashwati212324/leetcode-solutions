class Solution {
    public int[] runningSum(int[] nums) {
        // APPROACH 1 - normal loop 
        // int[] runningSum = new int[nums.length];
        // for(int i =0; i<nums.length;i++){
        //     for(int j =0; j<=i;j++){
        //         runningSum[i] += nums[j];
        //     }                
        // }
        // return runningSum;
        //APPROACH -2 - prefix sum
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i =1; i<nums.length; i++){
            prefix[i] += prefix[i-1]+nums[i];
        }
        return prefix;
    }
}