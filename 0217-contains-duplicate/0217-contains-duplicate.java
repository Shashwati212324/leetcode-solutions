import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
//Approach -1
        // Arrays.sort(nums);  
        // for (int i = 0; i < nums.length - 1; i++) {
        //     if (nums[i] == nums[i + 1]) {
        //         return true;  
        //     }
        // }
        //return false;  
//APPROACH - 2 ---- time limit exceeded - O(n2)
        // for(int i=0; i<nums.length ; i++){
        //     for(int j =i+1;j<nums.length;j++){
        //         if(nums[j]==nums[i]){
        //             return true;
        //         }
        //     }
        // }
        // return false;
    
        //Approach -3 --------Hashset
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length ;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;

        //Approach -4 ---------Optimized Hashset - O(N)-13ms
        // HashSet<Integer> set = new HashSet<>();
        // int left = 0;
        // int right = nums.length-1;
        // while(left<=right){
        //     if(!set.add(nums[left]))return true;
        //     if(left!=right){
        //         if(!set.add(nums[right]))return true;
        //     }
        //     left++;
        //     right--;
        // }
        // return false;
    }    

}
