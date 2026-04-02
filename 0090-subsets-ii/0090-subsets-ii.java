class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(list, answer, nums, 0);
        return answer;
    }
    public void backtrack(ArrayList<Integer> list, List<List<Integer>> answer, int[] nums, int start){
        answer.add(new ArrayList<>(list));
        for(int i=start; i<nums.length; i++){

            if(i>start && nums[i]==nums[i-1])continue;

            list.add(nums[i]);
            backtrack(list, answer, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}