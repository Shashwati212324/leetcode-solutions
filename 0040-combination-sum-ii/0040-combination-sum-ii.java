class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        TargetList(candidates, 0,target,new ArrayList<>(), list);
        return list;
        
    }
    public static void TargetList(int[] nums,int start, int target, List<Integer> temp, List<List<Integer>> arr){
        if(target==0){
            arr.add(new ArrayList<>(temp));
            return;
        }
        if(target<0)return;
        for(int i=start; i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            TargetList(nums,i+1, target-nums[i],temp,arr);
            temp.remove(temp.size()-1);
        }
    }
    
}