class Solution {
    public int singleNumber(int[] nums) {
        // int result =0;
        // for(int i =0; i<32; i++){
        //     int sum = 0;
        //     int mask = (1<<i);
        //     for(int num: nums){
        //         if((num&mask)!=0){
        //             sum++;
        //         }
        //     }
        //     if(sum%3 != 0){
        //         result |= mask; 
        //     } 
        // }
        // return result;

        int[] ar = new int[32];
        for(int i =0; i<32; i++){
            for(int j =0 ;j<nums.length; j++){
                ar[i] += nums[j]&1;
                nums[j] = nums[j]>>1;
            }
        }
        int ans = 0;
        for(int i =0; i<32; i++){
            if(ar[i]%3!=0){
                ans = ans| (1<<i);
            }
        }
        return ans;

    }
}