class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
    //     // Cyclic Sort
    //     int i = 0;
    //     while (i < n) {
    //         int correctIndex = nums[i];
    //         if (nums[i] < n && nums[i] != nums[correctIndex]) {
    //             // Swap nums[i] with nums[correctIndex]
    //             int temp = nums[i];
    //             nums[i] = nums[correctIndex];
    //             nums[correctIndex] = temp;
    //         } else {
    //             i++;
    //         }
    //     }

    //     // Find missing number
    //     for (i = 0; i < n; i++) {
    //         if (nums[i] != i) {
    //             return i;
    //         }
    //     }

    //     // If all numbers are in place, return n
    //     return n;
    // }

    //--------------Brute Force-------0ms
    // int x = n*(n+1)/2;
    // int y =0;
    // for(int i =0; i<n; i++){
    //     y+= nums[i]; 
    // }
    // return x-y;

    //------------------HashSet----------
    HashSet<Integer> set = new HashSet<>();
    for(int num:nums){
        set.add(num);
    }

    for(int i =0; i<=nums.length ; i++){
        if(!set.contains(i)){
            return i;
        }

    }
    return -1;
    }
}
