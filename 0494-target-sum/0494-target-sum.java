class Solution {
    int count =0;
    public int findTargetSumWays(int[] nums, int target) {
        
        backtrack(nums, target, 0, 0);
        return count;
    }
    public void backtrack(int[] nums, int target, int index, int current){
        if(index == nums.length){
            if(current == target){
                count++;
            }
            return ;
        }
        backtrack(nums,target,index+1, current+nums[index]);
        backtrack(nums,target, index+1,current-nums[index]);
    }
}