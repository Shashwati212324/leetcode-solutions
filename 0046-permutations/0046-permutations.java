class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<Integer> list = new ArrayList<>();
       List<List<Integer>> answer = new ArrayList<>();
       boolean[] arr= new boolean[nums.length];
       backtrack(list, answer, arr, nums);
       return answer;

    }
    public void backtrack(List<Integer> list, List<List<Integer>> answer, boolean[] used, int[] nums){
        if(list.size()==nums.length){
            answer.add(new ArrayList<>(list));
            return;
        }
        for(int i =0; i<nums.length; i++){
            if(used[i])continue;

            used[i]=true;
            list.add(nums[i]);

            backtrack(list, answer, used, nums);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }

    
}
