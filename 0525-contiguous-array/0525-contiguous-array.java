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
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        int len =0, sum=0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i]==1?1:-1;

            if(map.containsKey(sum)){
               len = Math.max(len, i-map.get(sum));
            }else{
            map.put(sum,i);
            }
        }
        return len;

    }
}                