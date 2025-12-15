class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       HashSet<Integer> set = new HashSet<>();
       int left=0, diff =0;

       for(int i=0; i<nums.length ; i++){
        while(set.contains(nums[i])){
            diff = i-left;
            if(diff <= k){
                return true;
            }
            set.remove(nums[left]);
            left++;
            
        }
        set.add(nums[i]);
       }
       return false;        
    }
    
}