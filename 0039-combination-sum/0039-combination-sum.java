class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        int sum=0;
        backtrack(list,answer,candidates,0, target, sum);
        return answer;
    }
    public void backtrack(ArrayList<Integer> list, List<List<Integer>> answer, int[] nums, int start, int target, int sum){
        if(sum == target){
            answer.add(new ArrayList<>(list));
           
            return;
        }
        //if(start == nums.length && sum!= target)continue;

        for(int i =start; i<nums.length; i++){
            if(sum>target)return;
           
            list.add(nums[i]);
            backtrack(list, answer, nums,i,target,sum+nums[i]);
            list.remove(list.size()-1);
        }
    }
}