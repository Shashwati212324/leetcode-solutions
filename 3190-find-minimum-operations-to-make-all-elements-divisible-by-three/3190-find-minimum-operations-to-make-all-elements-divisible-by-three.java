class Solution {
    public int minimumOperations(int[] nums) {
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]%3 != 0){
                int mod = nums[i]%3;
                count += Math.min(mod,3-mod);
            }
        }
        return count;
    }
}