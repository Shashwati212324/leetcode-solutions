class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum=0, remainder =0, count =0;
        map.put(0,1);

        for(int num: nums){
            sum+=num;
            remainder = sum%k;

            if(remainder<0)remainder+=k;

            count += map.getOrDefault(remainder,0);
            map.put(remainder, map.getOrDefault(remainder,0)+1);            
        }
        return count;
    }
}