class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Arrays.sort(candidates);
       ArrayList<Integer> list = new ArrayList<>();
       List<List<Integer>> answer = new ArrayList<>();
       backtrack(list, answer, candidates, 0, 0, target);
       return answer;
    }
    public void backtrack(ArrayList<Integer> list,List<List<Integer>> answer,int[] nums, int sum, int start,int target){
        if(sum == target){
            answer.add(new ArrayList<>(list));
            return;
        }
        //if(start > nums.length && sum != target)return;
        for(int i = start; i<nums.length; i++){
            if(sum+nums[i]>target)return;
            
            if(i>start && nums[i]==nums[i-1])continue;
            list.add(nums[i]);
            backtrack(list, answer, nums, sum+nums[i], i+1, target);
            list.remove(list.size()-1);
            
        }
    }
    
}