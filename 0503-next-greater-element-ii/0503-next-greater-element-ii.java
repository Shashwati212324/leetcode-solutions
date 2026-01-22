class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans= new int[nums.length];

        int l = nums.length;
        for (int i = 0; i < l; i++) {
            ans[i] = -1;
        }

    
        for(int i =0; i<2*l; i++){
            int index = i%l;
            while(!stack.isEmpty() && nums[index]>nums[stack.peek()]){
                int ind = stack.pop();
                ans[ind] = nums[index];
            }
            if(i<l){
                stack.push(i);
            }
        }
        return ans;
    }
}