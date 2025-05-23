class Solution {
    public int search(int[] nums, int target) {
        return BinarySearch(nums, target, 0,nums.length-1);
    }
    public static int BinarySearch(int[] nums, int target, int s, int e){
        if(s>e){
            return -1;
        }
        int mid = s+(e-s)/2;
        if(nums[mid]<target){
            return BinarySearch(nums, target, mid+1 ,e);
        }
        else if(nums[mid]>target){
            return BinarySearch(nums, target,s, mid-1);
        }
        else{
            return mid;
        }
        
    }
}