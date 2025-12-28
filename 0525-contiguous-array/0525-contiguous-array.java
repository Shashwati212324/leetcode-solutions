class Solution {
    public int findMaxLength(int[] nums) {
        //brute force - n2
        // int max = 0;
        // for(int i =0; i<nums.length; i++){
        //     int zeros = 0;
        //     int ones=0;
        //     for(int j=i; j<nums.length; j++){
        //         if(nums[j]==0)zeros++;
        //         else ones++;

        //         if(zeros == ones){
        //             max = Math.max(max, j-i+1);
        //         }
        //     }
        // }
        // return max;

        //optimized - hashmap - n
        Map<Integer, Integer> map = new HashMap<>();
        map.put(o,-1);
        int max =0, count =0;
        for(int i =0; i<nums.length; i++){
            count += (nums[i]==1?1:-1);
            if(map.containsKey(count)){
                max = Math.max(max, i-map.get(count));
            }
            else{
                map.put(count,i);
            }
        }
        return max;

    }
}                