class Solution {
    public int[] plusOne(int[] digits) {
        int[] ans = plus(digits.length-1, digits);
        return ans;
    }
    public int[] plus(int index, int[] nums){
        int carry =0;
            for(int i=index; i>=0;i--){
                if(nums[i]<9){
                    nums[i]++;
                    //carry=0;
                    return nums;
                }else{
                    nums[i]=0;
                    carry =1;
                }
            }
            if (carry == 1) {
            int[] arr = new int[nums.length + 1];
            arr[0] = 1; 
            return arr;
        }
        return nums; 
    }
}