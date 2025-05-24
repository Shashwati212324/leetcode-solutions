import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
//Approach -1
        Arrays.sort(nums);  
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;  
            }
        }
        return false;  
//APPROACH - 2 ---- time limit exceeded - O(n2)
        // for(int i=0; i<nums.length ; i++){
        //     for(int j =i+1;j<nums.length;j++){
        //         if(nums[j]==nums[i]){
        //             return true;
        //         }
        //     }
        // }
        // return false;
    }
}
