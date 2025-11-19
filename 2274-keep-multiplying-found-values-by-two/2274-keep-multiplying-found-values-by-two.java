class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        return binarySearch(nums, original,0, nums.length-1);
       
    }
   
    public int binarySearch(int[] nums, int target, int s, int e) {
        if (s > e) {
            return target; // If not found, return final value
        }

        int mid = s + (e - s) / 2;

        if (nums[mid] == target) {
            // Found → multiply and search again from start
            return binarySearch(nums, target * 2, 0, nums.length - 1);
        } 
        else if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, e);
        } 
        else {
            return binarySearch(nums, target, s, mid - 1);
        }
    }
}