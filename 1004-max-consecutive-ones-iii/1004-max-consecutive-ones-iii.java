class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int sum=0, len =0, j=0;

        for(int i =0; i<nums.length; i++){
            sum+= nums[i]==0?1:0;
            while(sum>k){
                sum-= (nums[j]==0?1:0);
                j++;
                
            }
            
            len = Math.max(len, i-j+1);
        }
        return len;
    }
}