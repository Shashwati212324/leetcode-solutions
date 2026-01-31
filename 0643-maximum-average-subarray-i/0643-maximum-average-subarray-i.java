class Solution {
    public double findMaxAverage(int[] nums, int k) { 
        double avg = Integer.MIN_VALUE;
        for(int j=k-1; j<nums.length; j++){
            //int i = j-k+1;
            int sum=0;
            for(int i=j-k+1; i<=j;i++){
                sum+=nums[i];
            }
            avg = Math.max((double)sum/k, avg);

        }
        return avg;
    }
}