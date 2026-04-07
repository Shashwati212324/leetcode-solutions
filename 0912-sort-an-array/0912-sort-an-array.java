class Solution {
    public int[] sortArray(int[] nums) {
        //insertion sort
        // for(int i=1; i<nums.length; i++){
        //     int j =i-1;
        //     while(j>=0){
        //         if(nums[j]>nums[j+1]){
        //             int temp=nums[j];
        //             nums[j]=nums[j+1];
        //             nums[j+1]= temp;
        //         }
        //         j--;
        //     }
        // }
        // return nums;
        //selection sort
        int low =0, high =nums.length-1;
        quickSort(nums, low, high);
        return nums;
    }
    public void quickSort(int[] nums, int low, int high){
        if(high<=low)return;
        int s=low, e=high;
        int mid = (low+high)/2;
        int pivot = nums[mid];

        while(s<=e){
            while(nums[s]<pivot)s++;
            while(nums[e]>pivot)e--;

            if(s<=e){
                int temp = nums[s];
                nums[s]= nums[e];
                nums[e]= temp;
                s++;
                e--;
            }
        }
        quickSort(nums, low, e);
        quickSort(nums,s, high);
    }
}