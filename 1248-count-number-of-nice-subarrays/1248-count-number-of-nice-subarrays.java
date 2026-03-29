class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int sum=0,count =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i =0; i<nums.length; i++){
            sum += (nums[i]%2 !=0?1:0);

            if(map.containsKey(sum-k)){
                count+= map.getOrDefault(sum-k,0);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}