class Solution {
    public int numIdenticalPairs(int[] nums) {
        int  count=0;
        //APPROACH -1- LOOP
        // for(int  i =1; i<=nums.length-1 ; i++){
        //     int j =0;
        //     while(j<i){
        //         if(nums[i]==nums[j]){
        //             count++;
        //         }
        //         j++;   
        //     }
        // }
        //APPROACH -2- HASHMAP
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for(int val:map.values()){
            count += (val*(val-1))/2;
        }
        return count;
    }
}