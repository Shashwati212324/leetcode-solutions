
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums1.length];
        for (int i =0; i<nums1.length ; i++) {
            int val = nums1[i];
            boolean found = false;
            int index = findIndex(val, nums2);
            if(index < nums2.length-1){
                for (int j = index + 1; j < nums2.length; j++) {
                    if (nums2[j] > val) {
                        stack.push(nums2[j]);
                        found=true;
                        break;
                    }
                }    
            }
            if(!found){
                stack.push(-1);
            }           
            
        }
        
        
        for (int i = 0; i < nums1.length; i++) {
            result[i] = stack.pop();
        }
        return(reverse(result));
    }
    public int findIndex(int val, int[] nums){
        for(int i =0; i<nums.length ; i++ ){
            if(nums[i] == val){
                return i;
            }
        }
        return -1;
    }
    public int[] reverse(int[] nums){
        int i =0, e = nums.length-1; 
        while(i<e){
            int temp =nums[i];
            nums[i]=nums[e];
            nums[e] =temp;
            i++;
            e--;
        }
        return nums;
    }
}
