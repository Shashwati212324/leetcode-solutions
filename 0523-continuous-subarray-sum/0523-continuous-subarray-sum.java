class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();
        map.put(0,-1);  //remainder 0 at index -1
        int rem=0 , sum=0;
        for(int i =0; i<nums.length; i++){
            sum += nums[i];
            rem = sum%k;
            if(map.containsKey(rem)){
                if(i-map.get(rem)>=2)return true;
            }else{
                map.put(rem,i);  //store only the first occurance
            }
        }
        return false;
    }
}