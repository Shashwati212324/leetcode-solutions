class Solution {
    public int findKthLargest(int[] nums, int k) {
        //without sorting - heap

        //done with sortin - quick sort
        int high=nums.length-1, low = 0;
        quicksort(nums, low, high);

        return nums[nums.length - k];
        
    }
    public void quicksort(int[] nums, int low, int high){
        if(low>=high)return;
        int s=low, e=high;
        int mid= (low+high)/2;
        int pivot = nums[mid];

        while(s<=e){
            while(nums[s]<pivot)s++;
            while(nums[e]>pivot)e--;

            if(s<=e){
                int temp= nums[s];
                nums[s]=nums[e];
                nums[e]=temp;
                s++;
                e--;
            }
        }
        quicksort(nums, low, e);
        quicksort(nums, s, high);
    }
    
}