class Solution {
    public int minimumCost(int[] nums) {
        int first = nums[0];
        int secondSmallest= Integer.MAX_VALUE;
        int thirdSmallest = Integer.MAX_VALUE;
        for(int i =1; i<nums.length; i++){
            if(nums[i]<secondSmallest){
                thirdSmallest = secondSmallest;
                secondSmallest = nums[i];
            }
            else if(nums[i]<thirdSmallest){
                thirdSmallest = nums[i];
            }
        }
        return first+secondSmallest+thirdSmallest;
    }
}