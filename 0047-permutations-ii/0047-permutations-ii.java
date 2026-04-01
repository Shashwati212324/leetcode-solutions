class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] used= new boolean[nums.length];

        backtrackDuplicates(used, nums, list, answer);
        return answer;
       
    }
    public void backtrackDuplicates(boolean[] used, int[] nums, ArrayList<Integer> list, List<List<Integer>> answer){
        if(list.size() == nums.length){
            answer.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i])continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1])continue;
            
            used[i]=true;
            list.add(nums[i]);
            backtrackDuplicates(used, nums, list ,answer);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}