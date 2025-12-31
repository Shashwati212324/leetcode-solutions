class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //odd------one
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int ones =0;
        int count =0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==1)ones++;
            count += map.getOrDefault(ones-k,0);
            map.put(ones,map.getOrDefault(ones,0)+1);
        }
        return count;
    }
}