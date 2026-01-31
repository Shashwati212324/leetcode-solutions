class Solution {
    public double findMaxAverage(int[] nums, int k) { 
        //APPROACH -  1
        // double avg = Integer.MIN_VALUE;
        // for(int j=k-1; j<nums.length; j++){
        //     //int i = j-k+1;
        //     int sum=0;
        //     for(int i=j-k+1; i<=j;i++){
        //         sum+=nums[i];
        //     }
        //     avg = Math.max((double)sum/k, avg);

        // }
        // return avg;

        //APPROACH -2 - OPTIMIZED
        int sum =0;
        for(int i =0; i<k; i++){
            sum += nums[i];
        }
        double avg = (double)sum/k;
        for(int i =k; i<nums.length ; i++){
            sum = sum + nums[i] - nums[i-k];
            avg = Math.max((double)sum/k, avg);
        }
        return avg;
    }
}