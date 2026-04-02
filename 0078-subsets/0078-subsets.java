class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> answer = new ArrayList<>();
       ArrayList<Integer> list = new ArrayList<>();
       int s =0;
       subsetDuplicates(list, answer, nums, s);
       return answer;
    }
    public void subsetDuplicates(ArrayList<Integer> list, List<List<Integer>> answer, int[] nums, int start){
        answer.add(new ArrayList<>(list));
        for(int i = start; i<nums.length; i++){
            list.add(nums[i]);
            subsetDuplicates(list, answer, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}