class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(list,new ArrayList<>(),visited, nums);
        return list;
    }
    public void backtrack(List<List<Integer>> list, List<Integer> temp, boolean[] visited, int[] nums){
        if(temp.size()==nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i =0; i<nums.length ;i++){
            if(visited[i] == true)continue;
            if(i>0 && nums[i]==nums[i-1] && !visited[i-1])continue;
            visited[i]=true;
            temp.add(nums[i]);
            backtrack(list,temp,visited,nums);
            temp.remove(temp.size()-1);
            visited[i]=false;
        }
    }
}