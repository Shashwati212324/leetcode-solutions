public class Solution {
    public static int majorityElement(int[] nums) {  
// APPROACH - 1 - WITHOUT SRTING, USING LOOP
        // if(nums.length == 1){
        //     return nums[0];
        // }    
        // for(int j=0;j<nums.length;j++){
        //     int count =1;
            
        //         for(int i=j+1;i<nums.length;i++){
        //             if(nums[i]==nums[j]){
        //                 count++;
        //             }
        //             if(count>nums.length/2){
                        
        //                 return nums[j];
        //             }
        //         }
            
            
        // }
        // return -1;

// APPROACH - 2 - sorting the array

        // for(int i=0; i<nums.length-1; i++){
        //     for(int j =i+1; j>0;j--){
        //         if(nums[j]<nums[j-1]){
        //             int temp = nums[j];
        //             nums[j] = nums[j-1];
        //             nums[j-1]= temp;
        //         }
        //     }
        // }
        // int count =1;
        // int finalee = nums[0];
        // for(int i =0; i<nums.length-1 ;i++){
        //     if(nums[i]==nums[i+1]){
        //         count++;
        //         if(count>nums.length/2){
        //             finalee= nums[i];
        //         }
        //     }
        //     else{
        //         count = 1;
        //     }
            
        // }
        // return finalee; 
// APPROACH - 3 - MOORE VOTING ALGORITHM
    int count = 0;
    int candidate = 0;

    for (int num : nums) {
        if (count == 0) {
            candidate = num;
        }
        count += (num == candidate) ? 1 : -1;
    }

    return candidate;           
        
    }
}
